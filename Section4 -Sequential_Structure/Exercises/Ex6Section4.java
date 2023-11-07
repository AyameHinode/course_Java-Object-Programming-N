package Exercises;

import java.util.Scanner;

public class Ex6Section4 {

    public static void main(String [] args){

        final double pi = 3.14159;
        Scanner entrada = new Scanner(System.in);
        double A = entrada.nextDouble();
        double B = entrada.nextDouble();
        double C = entrada.nextDouble();

        double triangulo = A*C / 2;
        double circulo = pi*(Math.pow(C, 2));
        double trapezio = ((A+B)/2)*C;
        double quadrado = B*B;
        double retangulo = A*B;

        System.out.printf("TRIANGULO: %.3f %n", triangulo);
        System.out.printf("CIRCULO: %.3f %n", circulo);
        System.out.printf("TRAPEZIO: %.3f %n", trapezio);
        System.out.printf("QUADRADO: %.3f %n", quadrado);
        System.out.printf("RETANGULO: %.3f %n", retangulo);

    }

}
