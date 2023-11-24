package br.ce.wcaquino.servicos;

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
        Usuario user = new Usuario("Ayame");
        List<Filme> filmes = Arrays.asList(new Filme("O gato de botas", 1, 10.50));

        //acao
        Locacao locacao = locacaoService.alugarFilme(user, filmes);

        //verificacao
        errorCollector.checkThat((locacao.getValor()), CoreMatchers.is(CoreMatchers.equalTo(10.50)));
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
        Usuario user = new Usuario("Ayame");
        List<Filme> filmes = Arrays.asList(new Filme("O gato de botas", 0, 10.50));

        //acao
        Locacao locacao = locacaoService.alugarFilme(user, filmes); //O codigo para aqui
    }

    @Test
    public void deveLancarExcecaoAoAlugarSemUsuarioDefinido() throws Exception {

        System.out.println("Forma Robusta");

        //cenario
        List<Filme> filmes = Arrays.asList(new Filme("Harry Potter", 5, 20.0));

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
        Usuario usuario = new Usuario("User 1");

        exceptionExpected.expect(LocadoraException.class);
        exceptionExpected.expectMessage("Filme vazio");

        //acao
        locacaoService.alugarFilme(usuario, null); //O codigo para aqui

    }

    @Test
    public void deveDevolverNaSegundaAoAlugarNoSabado() throws FilmeSemEstoqueException, LocadoraException {
        Assume.assumeTrue(DataUtils.verificarDiaSemana(new Date(), Calendar.SATURDAY)); //Executara o teste apenas sabado

        //cenario
        Usuario usuario = new Usuario("Usuario 1");
        List<Filme> filmes = Arrays.asList(new Filme("Filme 1", 1, 5.00));

        //acao
        Locacao retorno = locacaoService.alugarFilme(usuario, filmes);

        //verificacao
        boolean segunda = DataUtils.verificarDiaSemana(retorno.getDataRetorno(), Calendar.MONDAY);
        Assert.assertTrue(segunda);

//        Assert.assertThat(retorno.getDataRetorno(), new DiaSemanaMatcher(Calendar.MONDAY));
//        Assert.assertThat(retorno.getDataRetorno(), caiEm(Calendar.MONDAY));
        Assert.assertThat(retorno.getDataRetorno(), caiEmUmaSegunda());
    }
  
}