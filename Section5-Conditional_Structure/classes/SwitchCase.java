package classes;

import java.util.Scanner;

public class SwitchCase {

    public static void main (String ... args){

        Scanner entrada = new Scanner(System.in);
        int numeroDia = entrada.nextInt();
        String dia;

        switch (numeroDia){
            case 1:
                dia = "domingo";
                break;
            case 2:
                dia = "segunda";
                break;
            case 3:
                dia = "terça";
                break;
            case 4:
                dia = "quarta";
                break;
            case 5:
                dia = "quinta";
                break;
            case 6:
                dia = "sexta";
                break;
            case 7:
                dia = "sabado";
                break;
            default:
                dia = "valor invalido";
                break;
        }

        System.out.println("Dia da semana: "+ dia);
        entrada.close();

    }

}
