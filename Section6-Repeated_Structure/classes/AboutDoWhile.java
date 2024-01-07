package classes;

import java.util.Locale;
import java.util.Scanner;

public class AboutDoWhile {

    static public void main(String... args) {

        Locale.setDefault(Locale.US);
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite a temperatura em Celsius: ");
        double C = entrada.nextDouble();
        double F = 9.0 * C / 5.0 + 32.0;
        System.out.printf("Equivalente em Fahrenheit: %.1f%n", F);
        System.out.print("Deseja repetir (s/n)? ");
        char resp = entrada.next().charAt(0);

        while (resp != 'n')
    }

}