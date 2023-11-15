package classes;

import java.util.Scanner;

public class IfElseExemplo {

    public static void main(String ... args){

        Scanner entrada = new Scanner(System.in);
        int minutos = entrada.nextInt();

        double conta = 50.0;
        if (minutos > 100){
            //conta = conta + (minutos - 100) * 2.0;
            conta += (minutos - 100) * 2.0;
        }

        System.out.printf("Valor da conta = R$ %.2f%n", conta);
        entrada.close();

    }

}
