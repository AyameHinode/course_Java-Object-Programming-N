package classes;

import java.util.Scanner;

public class AboutFunctions {

    static public void main(String ... args){

        Scanner entrada = new Scanner(System.in);

        System.out.println("Entre com três números: ");
        int x = entrada.nextInt();
        int z = entrada.nextInt();
        int y = entrada.nextInt();

        int maiorNumero = maior(x, z, y);

        mostrarResultado(maiorNumero);

        entrada.close();

    }

    private static void mostrarResultado(int numero) {
        System.out.println("Maior = " + numero);
    }

    public static int maior(int a, int b, int c) {

        if (a > b && a > c){
            return a;
        }else if (b>c) {
            return b;
        } else {
            return c;
        }

    }

}
