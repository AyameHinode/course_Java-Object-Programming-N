package exercises;

import java.util.Scanner;

public class Ex2Section5 {

    static public void main(String ... lista){

        Scanner entrada = new Scanner(System.in);
        int number = entrada.nextInt();

        if(number%2 == 0){
            System.out.println("PAR");
        } else {
            System.out.println("IMPAR");
        }

        entrada.close();

    }

}
