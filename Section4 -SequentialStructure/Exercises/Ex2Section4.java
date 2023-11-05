package Exercises;

import java.util.Scanner;

public class Ex2Section4 {

    public static void main(String[] args){

        Scanner entrada = new Scanner(System.in);
        final double pi = 3.14159;
        double raio = entrada.nextDouble();

        double area = pi * (Math.pow(raio, 2));

        System.out.printf("A=%.4f", area);

    }

}
