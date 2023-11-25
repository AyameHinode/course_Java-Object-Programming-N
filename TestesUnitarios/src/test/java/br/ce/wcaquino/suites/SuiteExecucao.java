package br.ce.wcaquino.suites;

import br.ce.wcaquino.servicos.CalculadoraTest;
import br.ce.wcaquino.servicos.CalculoValorLocacaoTest;
import br.ce.wcaquino.servicos.LocacaoServiceTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//@RunWith(Suite.class)
@Suite.SuiteClasses({
        CalculadoraTest.class,
        CalculoValorLocacaoTest.class,
        LocacaoServiceTest.class
})
public class SuiteExecucao {

    @BeforeClass
    public static void antesDeTudo(){
        System.out.println("Executado bateria de testes");
    }

    @AfterClass
    public static void depoisDeTudo(){
        System.out.println("Finalizando execução de todos os testes");
    }

}
