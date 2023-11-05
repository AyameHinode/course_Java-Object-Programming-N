package Exercises;

import java.util.Scanner;

public class Ex4Section4 {

    public static void main(String [] args) {

        Scanner entrada = new Scanner(System.in);
        int numero = entrada.nextInt();
        int horas = entrada.nextInt();
        double ganhos = entrada.nextDouble();

        double salario = horas * ganhos;

        System.out.println("NUMBER = " + numero);
        System.out.printf("SALARY = U$ %.2f", salario);

    }

}
