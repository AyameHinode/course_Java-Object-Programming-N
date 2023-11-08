package exercises;

import java.util.Scanner;

public class Ex3Section5 {

    static public void main(String [] args){

        Scanner entrada = new Scanner(System.in);
        int number1 = entrada.nextInt();
        int number2 = entrada.nextInt();
        int resultado;

        if (number1 > number2){
            resultado = number1 % number2;
            if (resultado != 0){
                System.out.println("Nao Sao Multiplos");
            } else {
                System.out.println("Sao Multiplos");
            }
        } else {
            resultado = number2 % number1;
            if (resultado != 0){
                System.out.println("Nao Sao Multiplos");
            } else {
                System.out.println("Sao Multiplos");
            }
        }

        entrada.close();

    }

}
