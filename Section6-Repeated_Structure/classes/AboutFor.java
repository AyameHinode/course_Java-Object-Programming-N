package classes;

import java.util.Scanner;

public class AboutFor {

    public static void main(String ... args){

        Scanner entrada = new Scanner(System.in);

        int numero = entrada.nextInt();
        int soma = 0;

        for (int i = 0; i<numero ; i ++){
            int acrescimo = entrada.nextInt();
            soma = soma + acrescimo;
        }

        System.out.println(soma);
        entrada.close();

    }

}
