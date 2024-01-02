package exercices;

import java.util.Scanner;

public class Ex7Section6 {
//Calculando fatorial
    public static void main(String ... args){

        Scanner entrada = new Scanner(System.in);

        int numero = entrada.nextInt();

        if(numero != 0){
            for(int i=numero-1; i>=1; i--){
                numero = numero * i;
            }
        } else {
            numero = 0;
        }

        System.out.println(numero);

        entrada.close();
    }

}
