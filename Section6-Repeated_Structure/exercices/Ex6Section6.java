package exercices;

import java.util.Scanner;

public class Ex6Section6 {

    public static void main (String ... args){

        Scanner entrada = new Scanner(System.in);

        int quantidadeTestes = entrada.nextInt();
        double primeiro, segundo, terceiro, total;

        for(int i = 0; i<quantidadeTestes; i++){

            primeiro = entrada.nextDouble();
            segundo = entrada.nextDouble();
            terceiro = entrada.nextDouble();

            total = (primeiro * 2 + segundo * 3 + terceiro * 5)/10;
            System.out.printf("%.1f%n", total);

        }

        entrada.close();

    }

}
