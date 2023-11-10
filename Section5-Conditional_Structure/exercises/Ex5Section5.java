package exercises;

import java.util.Scanner;

public class Ex5Section5 {

    public static void main(String [] args){

        Scanner entrada = new Scanner(System.in);
        int codigo = entrada.nextInt();
        int quantidade = entrada.nextInt();
        double total;

        if ( codigo == 1 ){
            total = quantidade * 4.0;
        } else if (codigo == 2) {
            total = quantidade * 4.5;
        } else if (codigo == 3) {
            total = quantidade * 5.0;
        } else if (codigo == 4) {
            total = quantidade * 2.0;
        } else {
            total = quantidade * 1.5;
        }

        System.out.printf("Total: R$ %.2f", total);

        entrada.close();

    }

}
