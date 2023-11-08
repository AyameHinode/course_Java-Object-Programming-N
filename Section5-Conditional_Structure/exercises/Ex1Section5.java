package exercises;

import java.util.Scanner;

public class Ex1Section5 {

    public static void main(String [] args){

        Scanner entrada = new Scanner(System.in);
        int number = entrada.nextInt();

        if(number < 0){
            System.out.println("NEGATIVO");
        } else {
            System.out.println("NAO NEGATIVO");
        }

        entrada.close();

    }

}
