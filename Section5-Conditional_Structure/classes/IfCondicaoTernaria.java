package classes;

import java.util.Scanner;

public class IfCondicaoTernaria {

    public static void main(String[] args){

        Scanner entrada = new Scanner(System.in);

        double preco = entrada.nextDouble();
        double desconto = (preco < 10) ? preco * 0.1 : preco * 0.2;

        System.out.println(desconto);

        entrada.close();
    }

}
