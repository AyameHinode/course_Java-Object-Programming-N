package br.ce.wcaquino.servicos;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

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
        Assert.assertEquals(10.50, locacao.getValor(), 0.01);
        Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
        Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(),
                DataUtils.obterDataComDiferencaDias(1)));
    }
  
}