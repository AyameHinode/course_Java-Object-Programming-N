package exercices;

import java.util.Scanner;

public class Ex10Section6 {

    static public void main(String ... args){

        Scanner entrada = new Scanner(System.in);

        int inteiro = entrada.nextInt();
        int quadrado, cubo;

        for(int i=1; i<=inteiro; i++){
            quadrado = i*i;
            cubo = i*i*i;

            System.out.println(i + " " + quadrado + " " + cubo); //Use aspas duplas, se usar simples dara erro
        }

        entrada.close();

    }

}
