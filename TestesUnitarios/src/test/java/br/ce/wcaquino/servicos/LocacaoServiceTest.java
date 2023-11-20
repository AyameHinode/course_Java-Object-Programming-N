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

import java.util.Date;

import static org.junit.Assert.*;

public class LocacaoServiceTest {

    LocacaoService locacaoService;

    @Rule
    public ErrorCollector errorCollector = new ErrorCollector();

    @Rule
    public ExpectedException exceptionExpected = ExpectedException.none();

    @Before
    public void setup() {
        System.out.println("Before Method");
        locacaoService = new LocacaoService();
    }

    @After
    public void tearDown(){
        System.out.println("After Method");
    }

    @BeforeClass
    public static void setupClass() {
        System.out.println("Before Class");
    }

    @AfterClass
    public static void tearDownClass(){
        System.out.println("After Class");
    }

    @Test
    public void primeiroTeste() throws Exception {
        //cenario
        LocacaoService locacaoService = new LocacaoService();
        Usuario user = new Usuario("Ayame");
        Filme filme = new Filme("O gato de botas", 1, 10.50);

        //acao
        Locacao locacao = locacaoService.alugarFilme(user, filme);

        //verificacao
        errorCollector.checkThat((locacao.getValor()), CoreMatchers.is(CoreMatchers.equalTo(10.50)));
        errorCollector.checkThat(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()), CoreMatchers.is(true));
        errorCollector.checkThat(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)), CoreMatchers.is(true));

    }

    @Test (expected = FilmeSemEstoqueException.class)
    public void testeLocacaoFilmeSemEstoqueModoElegante() throws Exception {

        System.out.println("Forma Elegante");

        //cenario

        Usuario user = new Usuario("Ayame");
        Filme filme = new Filme("O gato de botas", 0, 10.50);

        //acao
        Locacao locacao = locacaoService.alugarFilme(user, filme); //O codigo para aqui
    }

    @Test
    public void testeUsuarioVazio() throws Exception {

        System.out.println("Forma Robusta");

        //cenario
        LocacaoService servico = new LocacaoService();
        Filme filme = new Filme("Harry Potter", 5, 20.0);

        //acao
        try {
            servico.alugarFilme(null, filme);
            Assert.fail();
        } catch (LocadoraException erro) {
            Assert.assertThat(erro.getMessage(), CoreMatchers.is("Usuario vazio"));
        }

        //O codigo pode continuar

    }

    @Test
    public void testeFilmeVazio() throws FilmeSemEstoqueException, LocadoraException {

        System.out.println("Forma Nova");

        //cenario
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("User 1");

        exceptionExpected.expect(LocadoraException.class);
        exceptionExpected.expectMessage("Filme vazio");

        //acao
        service.alugarFilme(usuario, null); //O codigo para aqui

    }
  
}