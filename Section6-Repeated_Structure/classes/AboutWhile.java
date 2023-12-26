package classes;

import java.util.Scanner;

public class AboutWhile {

    public static void main(String[] args){

        Scanner entrada = new Scanner(System.in);

        int teste = entrada.nextInt();
        int soma = 0;

        while (teste != 0){
            soma = soma + teste;
            teste = entrada.nextInt();
        }

        entrada.close();

    }

}
