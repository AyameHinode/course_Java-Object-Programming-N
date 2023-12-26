package exercices;

import java.util.Scanner;

public class Ex3Section6 {

    public static void main(String ... args){

        Scanner entrada = new Scanner(System.in);

        int tipoCombustivel = entrada.nextInt();
        int alcool = 0, gasolina = 0, diesel = 0;

        while(tipoCombustivel != 4){
            if(tipoCombustivel == 1){
                alcool = alcool + 1;
            } else if(tipoCombustivel == 2){
                gasolina = gasolina +1;
            } else if (tipoCombustivel == 3){
                diesel = diesel + 1;
            }
            tipoCombustivel = entrada.nextInt();
        }

        entrada.close();

        System.out.println("MUITO OBRIGADO");
        System.out.println("Alcool: " + alcool);
        System.out.println("Gasolina: " + gasolina);
        System.out.println("Diesel: " + diesel);

    }

}
