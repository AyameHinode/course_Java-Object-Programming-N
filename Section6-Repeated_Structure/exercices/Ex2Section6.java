package exercices;

import java.util.Scanner;

public class Ex2Section6 {

    public static void main(String ... args){

        Scanner entrada = new Scanner(System.in);

        int x = entrada.nextInt();
        int y = entrada.nextInt();

        while(x != 0 && y != 0){
            if (x>0 && y> 0){
                System.out.println("primeiro");
            } else if (x<0 && y>0) {
                System.out.println("segundo");
            } else if (x<0 && y<0) {
                System.out.println("terceiro");
            } else {
                System.out.println("quarto");
            }

            x = entrada.nextInt();
            y = entrada.nextInt();
        }

    }

}
