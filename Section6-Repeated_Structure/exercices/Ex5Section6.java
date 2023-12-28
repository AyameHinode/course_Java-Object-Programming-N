package exercices;

import java.util.Scanner;

public class Ex5Section6 {

    static public void main(String ... args){

        Scanner entrada = new Scanner(System.in);

        int quantidadeNum = entrada.nextInt();
        int quantidadeFora = 0, quantidadeDentro =0;
        int numero = 0;
        for(int i = 0; i < quantidadeNum; i ++){
            numero = entrada.nextInt();
            if (numero >= 10 && numero <= 20){
                quantidadeDentro ++;
            } else {
                quantidadeFora ++;
            }
        }

        System.out.println(quantidadeDentro + " in");
        System.out.println(quantidadeFora + " out");

        entrada.close();
    }

}
