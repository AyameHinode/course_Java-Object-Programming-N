package exercises;

import java.util.Scanner;

public class Ex7Section5 {

    public static void main(String ... args){

        Scanner entrada = new Scanner(System.in);
        double x = entrada.nextDouble();
        double y = entrada.nextDouble();

        if (x == 0 && y == 0){
            System.out.println("Origem");
        } else if (x == 0){
            System.out.println("Eixo X");
        } else if (y == 0){
            System.out.println("Eixo Y");
        } else if (x > 0 && y > 0){
            System.out.println("Q1");
        } else if (x < 0 && y > 0){
            System.out.println("Q2");
        } else if (x < 0 && y < 0){
            System.out.println("Q3");
        } else {
            System.out.println("Q4");
        }

        entrada.close();

    }

}
