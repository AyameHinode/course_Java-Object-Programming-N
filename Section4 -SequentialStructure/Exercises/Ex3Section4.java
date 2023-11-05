package Exercises;

import java.util.Scanner;

public class Ex3Section4 {

    public static void main(String[] args){

        Scanner entrada = new Scanner(System.in);
        int A = entrada.nextInt();
        int B = entrada.nextInt();
        int C = entrada.nextInt();
        int D = entrada.nextInt();

        int diferenca = (A*B) - (C*D);

        System.out.println("DIFERENÇA = " + diferenca);

    }

}
