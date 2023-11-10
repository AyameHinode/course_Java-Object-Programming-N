package exercises;

import java.util.Scanner;

import static java.lang.Math.abs;

public class Ex4Section5 {

    static public void main(String ... args){

        Scanner entrada = new Scanner(System.in);
        int comeco = entrada.nextInt();
        int fim = entrada.nextInt();
        int total;

        if(comeco > 24 || fim > 24){
            System.out.println("Hora invalida");
        }else{
            if (comeco > fim){
                total = 24 - comeco + fim;

            } else if (comeco == fim){
                total = 24;
            } else {
                total = fim - comeco;
            }
            System.out.println("O JOGO DUROU " + total + " HORA(S)");
        }

        entrada.close();

    }

}
