package br.ce.wcaquino.servicos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

public class CalculadoraMockTest {

    @Mock
    private Calculadora calculadoraMock;

    @Spy
    private Calculadora calculadoraSpy;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void mostraDiferençaEntreMockSpy(){
        Mockito.when(calculadoraMock.somar(1,2)).thenReturn(10);
        //Mockito.when(calculadoraMock.somar(1, 2)).thenCallRealMethod(); //Imita o Spy
        System.out.println(calculadoraMock.somar(1,2));

        //Mockito.when(calculadoraSpy.somar(1,2)).thenReturn(10);
        Mockito.doReturn(10).when(calculadoraSpy).somar(1, 2);
        System.out.println(calculadoraSpy.somar(1,2));

        //Motodos Void Mock X Spy
        Mockito.doNothing().when(calculadoraSpy).imprime(); // Faça nada Spy
        System.out.println("Mock:");
        calculadoraMock.imprime();
        System.out.println("Spy:");
        calculadoraSpy.imprime();

    }

    @Test
    public void teste(){
        Calculadora calculadora = Mockito.mock(Calculadora.class);

        ArgumentCaptor<Integer> argumentCaptor = ArgumentCaptor.forClass(Integer.class);
        Mockito.when(calculadora.somar(argumentCaptor.capture(), argumentCaptor.capture())).thenReturn(5);
        Assert.assertEquals(5, calculadora.somar(1000, 10));
        //System.out.println(argumentCaptor.getAllValues());
    }
}
