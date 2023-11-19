package br.ce.wcaquino.servicos;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class LocacaoServiceTest {

    @Test
    public void primeiroTeste() {
        //cenario
        LocacaoService locacaoService = new LocacaoService();
        Usuario user = new Usuario("Ayame");
        Filme filme = new Filme("O gato de botas", 5, 10.50);

        //acao
        Locacao locacao = locacaoService.alugarFilme(user, filme);

        //verificacao
        Assert.assertThat((locacao.getValor()), CoreMatchers.is(CoreMatchers.equalTo(10.50)));
        Assert.assertThat((locacao.getValor()), CoreMatchers.is(CoreMatchers.not(5)));
        assertThat(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()), CoreMatchers.is(true));
        assertThat(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)), CoreMatchers.is(true));
    }
  
}