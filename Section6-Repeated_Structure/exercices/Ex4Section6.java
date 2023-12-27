package exercices;

import java.util.Scanner;

public class Ex4Section6 {

    static public void main(String ... vetor){

        Scanner entrada = new Scanner(System.in);

        int inteiro = entrada.nextInt();

        for(int i = 1; i <= inteiro; i = i+2){
            System.out.println(i);
        }

        entrada.close();

    }

}
