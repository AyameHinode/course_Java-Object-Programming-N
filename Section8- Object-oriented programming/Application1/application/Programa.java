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

        double areaX = x.area();
        double areaY = y.area();

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