package br.ce.wcaquino.servicos;

import br.ce.wcaquino.exceptions.NaoPodeDividirPorZeroException;
import br.ce.wcaquino.runners.ParallelRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(ParallelRunner.class)
public class CalculadoraTest {

    private Calculadora calculadora;

    @Before
    public void setup(){
        calculadora = new Calculadora();
        System.out.println("Iniciando....");
    }

    @After
    public void tearDown(){
        System.out.println("Finalizando....");
    }

    @Test
    public void deveSomarDoisValores(){
        //cenario
        int a = 2;
        int b = 4;

        //acao
        int resultado = calculadora.somar(a, b);

        //verificacao
        Assert.assertEquals(6, resultado);
    }

    @Test
    public void deveSubtrairDoisValores(){
        //cenario
        int a = 10;
        int b = 7;

        //acao
        int resultado = calculadora.subtrair(a, b);

        //verificacao
        Assert.assertEquals(3, resultado);
    }

    @Test
    public void deveDividirDoisValores() throws NaoPodeDividirPorZeroException {
        //cenario
        int a = 15;
        int b = 5;

        //acao
        int resultado = calculadora.dividir(a, b);

        //verificacao
        Assert.assertEquals(3, resultado);
    }

    @Test(expected = NaoPodeDividirPorZeroException.class)
    public void deveLancarExcecaoAoDividirPorZero() throws NaoPodeDividirPorZeroException {
        int a = 10;
        int b = 0;

        calculadora.dividir(a, b);
    }

}
