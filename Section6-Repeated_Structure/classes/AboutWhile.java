package classes;

import java.util.Scanner;

public class AboutWhile {

    public static void main(String[] args){

        Scanner entrada = new Scanner(System.in);

        int teste = entrada.nextInt();

        while (teste != 0){
            teste = entrada.nextInt();
        }

        entrada.close();

    }

}
