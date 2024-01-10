package classes;

import java.util.Scanner;

public class UsingBitwise {

    static public void main (String ... vetor){

        Scanner leitor = new Scanner(System.in);

        int mask = 0b100000;
        int n = leitor.nextInt();

        if ((n & mask) != 0){
            System.out.println("6th bit é verdadeiro");
        }
        else {
            System.out.println("6th bit é falso");
        }

        leitor.close();

    }

}
