package Exercises;

import java.util.Scanner;

public class Ex5Section4 {

    public static void main(String[] args){

        Scanner entrada = new Scanner(System.in);
        int codigo1 = entrada.nextInt();
        int quantidade1 = entrada.nextInt();
        double valor1 = entrada.nextDouble();
        int codigo2 = entrada.nextInt();
        int quantidade2 = entrada.nextInt();
        double valor2 = entrada.nextDouble();

        double valorTotal = (quantidade1 * valor1) + (quantidade2 * valor2);

        System.out.printf("VALOR A PAGAR: R$ %.2f", valorTotal);

    }

}
