package classes;

import java.util.Scanner;

public class IfElseStructure {

    public static void main(String [] args){

        Scanner entrada = new Scanner(System.in);
        System.out.println("Quantas horas?");
        int hora = entrada.nextInt();

        if (hora < 12) {
            System.out.println("Bom dia");
        }

        /* else {
            if (hora < 18){
                System.out.println("Boa tarde");
            } else {
                System.out.println("Boa noite");
            }
            if (hora < 18){
                System.out.println("Boa tarde");
            } else {
                System.out.println("Boa noite");
            }
        } */

        else if (hora < 18) {
            System.out.println("Boa tarde");
        }
        else {
            System.out.println("Boa noite");
        }

        entrada.close();

    }

}
