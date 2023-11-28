package br.ce.wcaquino.servicos;

import br.ce.wcaquino.builders.FilmeBuilder;
import br.ce.wcaquino.builders.UsuarioBuilder;
import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.LocadoraException;
import br.ce.wcaquino.utils.DataUtils;
import buildermaster.BuilderMaster;
import org.hamcrest.CoreMatchers;
import org.junit.*;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static br.ce.wcaquino.matchers.MatchersProprios.*;

public class LocacaoServiceTest {

    LocacaoService locacaoService;

    @Rule
    public ErrorCollector errorCollector = new ErrorCollector();

    @Rule
    public ExpectedException exceptionExpected = ExpectedException.none();

    @Before
    public void setup() {
        locacaoService = new LocacaoService();
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

    public static void main(String[] args){
        new BuilderMaster().gerarCodigoClasse(Locacao.class);
    }
  
}