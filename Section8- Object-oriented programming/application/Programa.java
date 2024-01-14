package application;

import entities.Triangulo;

import java.util.Locale;
import java.util.Scanner;

public class Programa {

    public static void main(String... args) {

        Locale.setDefault(Locale.US);
        Scanner leitor = new Scanner(System.in);

        Triangulo x, y;
        x = new Triangulo();
        y = new Triangulo();

        System.out.println("Entre com as medidas do triangulo X: ");
        x.a = leitor.nextDouble();
        x.b = leitor.nextDouble();
        x.c = leitor.nextDouble();

        System.out.println("Entre com as medidas do triangulo Y: ");
        y.a = leitor.nextDouble();
        y.b = leitor.nextDouble();
        y.c = leitor.nextDouble();

        double p = (x.a + x.b + x.c) / 2.0;
        double areaX = Math.sqrt(p * (p - x.a) * (p - x.b) * (p - x.c));

        p = (y.a + y.b + y.c) / 2.0;
        double areaY = Math.sqrt(p * (p - y.a) * (p - y.b) * (p - y.c));

        System.out.printf("Area do Triangulo X: %.4f%n", areaX);
        System.out.printf("Area do Triangulo Y: %.4f%n", areaY);

        if (areaX > areaY) {
            System.out.println("Maior area: X");
        } else {
            System.out.println("Maior area: Y");
        }

        leitor.close();

    }
}