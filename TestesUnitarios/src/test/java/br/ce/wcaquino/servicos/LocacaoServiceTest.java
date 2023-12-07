package br.ce.wcaquino.servicos;

import br.ce.wcaquino.builders.FilmeBuilder;
import br.ce.wcaquino.builders.LocacaoBuilder;
import br.ce.wcaquino.builders.UsuarioBuilder;
import br.ce.wcaquino.daos.LocacaoDAO;
import br.ce.wcaquino.daos.LocacaoDAOFake;
import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.LocadoraException;
import br.ce.wcaquino.utils.DataUtils;

import org.hamcrest.CoreMatchers;
import org.junit.*;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static br.ce.wcaquino.matchers.MatchersProprios.*;
import static org.mockito.Mockito.when;

public class LocacaoServiceTest {

    private LocacaoService locacaoService;
    private LocacaoDAO locacaoDAO;
    private SPCService spcService;
    private EmailService emailService;


    @Rule
    public ErrorCollector errorCollector = new ErrorCollector();

    @Rule
    public ExpectedException exceptionExpected = ExpectedException.none();

    @Before
    public void setup() {
        locacaoService = new LocacaoService();
        locacaoDAO = Mockito.mock(LocacaoDAO.class);
        locacaoService.setLocacaoDAO(locacaoDAO);
        spcService = Mockito.mock(SPCService.class);
        locacaoService.setSpcService(spcService);
        emailService = Mockito.mock(EmailService.class);
        locacaoService.setEmailService(emailService);
    }

    @Test
    public void deveAlugarFilmeComSucesso() throws Exception {
        //cenario
        Usuario user = UsuarioBuilder.criandoUsuarioFake().agora();
        List<Filme> filmes = Arrays.asList(FilmeBuilder.criandoUmFilme().filmeComValorLocacao(5.0).agora());

        //acao
        Locacao locacao = locacaoService.alugarFilme(user, filmes);

        //verificacao
        errorCollector.checkThat((locacao.getValor()), CoreMatchers.is(CoreMatchers.equalTo(5.00)));
        //errorCollector.checkThat(
                //DataUtils.isMesmaData(locacao.getDataLocacao(),
                        //new Date()), CoreMatchers.is(true));
        //errorCollector.checkThat(
                //DataUtils.isMesmaData(locacao.getDataRetorno(),
                        //DataUtils.obterDataComDiferencaDias(1)), CoreMatchers.is(true));
        errorCollector.checkThat(locacao.getDataRetorno(), hojeComDiferencaDias(1));
        errorCollector.checkThat(locacao.getDataLocacao(), hoje());

    }

    @Test (expected = FilmeSemEstoqueException.class)
    public void deveLancarExcecaoAoAlugarFilmeSemEstoque() throws Exception {

        System.out.println("Forma Elegante");

        //cenario
        Usuario user = UsuarioBuilder.criandoUsuarioFake().agora();
        List<Filme> filmes = Arrays.asList(FilmeBuilder.criandoUmFilme().semEstoque().agora());

        //acao
        Locacao locacao = locacaoService.alugarFilme(user, filmes); //O codigo para aqui
    }

    @Test
    public void deveLancarExcecaoAoAlugarSemUsuarioDefinido() throws Exception {

        System.out.println("Forma Robusta");

        //cenario
        List<Filme> filmes = Arrays.asList(FilmeBuilder.criandoUmFilme().agora());

        //acao
        try {
            locacaoService.alugarFilme(null, filmes);
            Assert.fail();
        } catch (LocadoraException erro) {
            Assert.assertThat(erro.getMessage(), CoreMatchers.is("Usuario vazio"));
        }

        //O codigo pode continuar

    }

    @Test
    public void deveLancarExcecaoAoAlugarSemFilmeDefinido() throws FilmeSemEstoqueException, LocadoraException {

        System.out.println("Forma Nova");

        //cenario
        Usuario usuario = UsuarioBuilder.criandoUsuarioFake().agora();

        exceptionExpected.expect(LocadoraException.class);
        exceptionExpected.expectMessage("Filme vazio");

        //acao
        locacaoService.alugarFilme(usuario, null); //O codigo para aqui

    }

    @Test
    public void deveDevolverNaSegundaAoAlugarNoSabado() throws FilmeSemEstoqueException, LocadoraException {
        Assume.assumeTrue(DataUtils.verificarDiaSemana(new Date(), Calendar.SATURDAY)); //Executara o teste apenas sabado

        //cenario
        Usuario usuario = UsuarioBuilder.criandoUsuarioFake().agora();
        List<Filme> filmes = Arrays.asList(FilmeBuilder.criandoUmFilme().agora());

        //acao
        Locacao retorno = locacaoService.alugarFilme(usuario, filmes);

        //verificacao
        boolean segunda = DataUtils.verificarDiaSemana(retorno.getDataRetorno(), Calendar.MONDAY);
        Assert.assertTrue(segunda);

//        Assert.assertThat(retorno.getDataRetorno(), new DiaSemanaMatcher(Calendar.MONDAY));
//        Assert.assertThat(retorno.getDataRetorno(), caiEm(Calendar.MONDAY));
        Assert.assertThat(retorno.getDataRetorno(), caiEmUmaSegunda());
    }

    @Test
    public void naoDeveAlugarFilmeParaNegativadosSPC() throws FilmeSemEstoqueException {
        //cenario
        Usuario usuario = UsuarioBuilder.criandoUsuarioFake().agora();
        List<Filme> filmes = Arrays.asList(FilmeBuilder.criandoUmFilme().agora());

        when(spcService.possuiNegativacao(usuario)).thenReturn(true);

        //acao
        try {
            locacaoService.alugarFilme(usuario,filmes);
            //verificacao
            Assert.fail();
        } catch (LocadoraException e) {
            Assert.assertThat(e.getMessage(), CoreMatchers.is("Usuário Negativado"));
        }


        Mockito.verify(spcService).possuiNegativacao(usuario);
    }

    @Test
    public void deveEnviarEmailParaLocacoesAtrasadas(){
        //cenario
        Usuario usuario = UsuarioBuilder.criandoUsuarioFake().agora();
        List<Locacao> locacoes = Arrays.asList(LocacaoBuilder.umLocacao()
                .comUsuario(usuario)
                .comDataRetorno(DataUtils.obterDataComDiferencaDias(-2))
                .agora());
        when(locacaoDAO.obterLocacoesPendentes()).thenReturn(locacoes);
        //acao
        locacaoService.notificarAtraso();
        //verificacao
        Mockito.verify(emailService).notificarAtraso(usuario);
    }

    @Test
    public void deveProrrogarUmaLocacao(){
        //cenario
        Locacao locacao = LocacaoBuilder.umLocacao().agora();

        //acao
        locacaoService.prorrogarLocacao(locacao,3);

        //verificacao
        ArgumentCaptor<Locacao> argumentCaptor = ArgumentCaptor.forClass(Locacao.class);
        Mockito.verify(locacaoDAO).salvar(argumentCaptor.capture());
        Locacao locacaoRetornada = argumentCaptor.getValue();

        errorCollector.checkThat(locacaoRetornada.getValor(), CoreMatchers.is(30.0));
        errorCollector.checkThat(locacaoRetornada.getDataLocacao(), hoje());
        errorCollector.checkThat(locacaoRetornada.getDataRetorno(), hojeComDiferencaDias(3));
    }

}