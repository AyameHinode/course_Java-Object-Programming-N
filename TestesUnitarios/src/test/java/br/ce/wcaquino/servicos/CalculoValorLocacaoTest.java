package br.ce.wcaquino.servicos;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.LocadoraException;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class CalculoValorLocacaoTest {

    @Parameterized.Parameter
    public List<Filme> filmes;
    @Parameterized.Parameter(value = 1)
    public Double valorLocacao;
    @Parameterized.Parameter(value = 2)
    public String cenario;
    private LocacaoService locacaoService;

    @Before
    public void setup(){
        locacaoService = new LocacaoService();
    }

    private static Filme filme1 = new Filme("Filme 1", 3, 10.00);
    private static Filme filme2 = new Filme("Filme 2", 3, 10.00);
    private static Filme filme3 = new Filme("Filme 3", 3, 10.00);
    private static Filme filme4 = new Filme("Filme 4", 3, 10.00);
    private static Filme filme5 = new Filme("Filme 5", 3, 10.00);
    private static Filme filme6 = new Filme("Filme 6", 3, 10.00);
    private static Filme filme7 = new Filme("Filme 7", 3, 10.00);

    @Parameterized.Parameters(name="{2}}")
    public static Collection<Object[]> getParametros(){
        return Arrays.asList(new Object[][]{
                {Arrays.asList(filme1, filme2), 20.00, "2 Filmes: Sem Desconto"},
                {Arrays.asList(filme1, filme2, filme3), 27.50, "3 Filmes: 25%"},
                {Arrays.asList(filme1, filme2, filme3, filme4), 32.50, "4 Filmes: 50%"},
                {Arrays.asList(filme1, filme2, filme3, filme4, filme5), 35.00, "5 Filmes: 75%"},
                {Arrays.asList(filme1, filme2, filme3, filme4, filme5, filme6), 35.00, "6 Filmes: 100%"},
                {Arrays.asList(filme1, filme2, filme3, filme4, filme5, filme6, filme7), 45.00, "7 Filmes: Sem Desconto"}
        });
    }

    @Test
    public void deveCalcularValorLocacaoConsiderandoDescontos() throws FilmeSemEstoqueException, LocadoraException {
        //cenario
        Usuario usuario = new Usuario("Usuario 1");

        //acao
        Locacao resultado = locacaoService.alugarFilme(usuario, filmes);

        //verificacao
        Assert.assertThat(resultado.getValor(), CoreMatchers.is(valorLocacao));
    }

}
