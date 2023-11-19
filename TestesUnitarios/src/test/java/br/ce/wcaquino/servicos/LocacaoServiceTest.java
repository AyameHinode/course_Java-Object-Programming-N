package br.ce.wcaquino.servicos;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import java.util.Date;

import static org.junit.Assert.*;

public class LocacaoServiceTest {

    @Rule
    public ErrorCollector errorCollector = new ErrorCollector();

    @Rule
    public ExpectedException exceptionExpected = ExpectedException.none();

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

    @Test (expected = Exception.class)
    public void testeLocacaoFilmeSemEstoqueModoElegante() throws Exception {
        //cenario
        LocacaoService locacaoService = new LocacaoService();
        Usuario user = new Usuario("Ayame");
        Filme filme = new Filme("O gato de botas", 0, 10.50);

        //acao
        Locacao locacao = locacaoService.alugarFilme(user, filme);
    }

    @Test
    public void testeLocacaoFilmeSemEstoqueModoRobusto() {
        //cenario
        LocacaoService locacaoService = new LocacaoService();
        Usuario user = new Usuario("Ayame");
        Filme filme = new Filme("O gato de botas", 0, 10.50);

        //acao
        try {
            Locacao locacao = locacaoService.alugarFilme(user, filme);
            Assert.fail("Deveria ter sido lançada uma exceção");
        } catch (Exception erro) {
            assertThat(erro.getMessage(), CoreMatchers.is("Filme sem estoque"));
        }
    }

    @Test
    public void testeLocacaoFilmeSemEstoqueModoNova() throws Exception {
        //cenario
        LocacaoService locacaoService = new LocacaoService();
        Usuario user = new Usuario("Ayame");
        Filme filme = new Filme("O gato de botas", 0, 10.50);

        exceptionExpected.expect(Exception.class);
        exceptionExpected.expectMessage("Filme sem estoque");

        //acao
        Locacao locacao = locacaoService.alugarFilme(user, filme);

    }
  
}