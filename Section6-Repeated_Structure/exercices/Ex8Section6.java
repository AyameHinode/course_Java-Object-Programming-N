package exercices;

import java.util.Scanner;

public class Ex8Section6 {

    public static void main (String[] args) {

        Scanner leitor = new Scanner(System.in);

        int pares = leitor.nextInt();
        double numerador, denominador, resultado;

        for (int i = 0; i < pares; i++) {
            numerador = leitor.nextDouble();
            denominador = leitor.nextDouble();
            if (denominador != 0) {
                resultado = numerador / denominador;
                System.out.println(resultado);
            } else {
                System.out.println("Divisão impossivel");
            }
        }

        leitor.close();

    }

}
