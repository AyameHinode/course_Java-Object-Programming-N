package br.ce.wcaquino.servicos;

import br.ce.wcaquino.builders.FilmeBuilder;
import br.ce.wcaquino.builders.UsuarioBuilder;
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

    private static Filme filme1 = FilmeBuilder.criandoUmFilme().agora();
    private static Filme filme2 = FilmeBuilder.criandoUmFilme().agora();
    private static Filme filme3 = FilmeBuilder.criandoUmFilme().agora();
    private static Filme filme4 = FilmeBuilder.criandoUmFilme().agora();
    private static Filme filme5 = FilmeBuilder.criandoUmFilme().agora();
    private static Filme filme6 = FilmeBuilder.criandoUmFilme().agora();
    private static Filme filme7 = FilmeBuilder.criandoUmFilme().agora();

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
        Usuario usuario = UsuarioBuilder.criandoUsuarioFake().agora();

        //acao
        Locacao resultado = locacaoService.alugarFilme(usuario, filmes);

        //verificacao
        Assert.assertThat(resultado.getValor(), CoreMatchers.is(valorLocacao));
    }

}
