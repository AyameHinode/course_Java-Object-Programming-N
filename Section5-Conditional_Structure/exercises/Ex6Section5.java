package exercises;

import java.util.Scanner;

public class Ex6Section5 {

    public static void main(String ... args){

        Scanner entrada = new Scanner(System.in);
        double numero = entrada.nextDouble();

        if(0 <= numero && numero <= 25){
            System.out.println("Intervalo (0,25]");
        } else if (25 <= numero && numero <= 50){
            System.out.println("Intervalo (25,50]");
        } else if (50 <= numero && numero <= 75){
            System.out.println("Intervalo (50,75]");
        } else if (75 <= numero && numero <= 100){
            System.out.println("Intervalo (75,100]");
        } else {
            System.out.println("Fora do intervalo");
        }

        entrada.close();

    }

}
