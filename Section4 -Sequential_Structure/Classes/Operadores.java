package Classes;

import java.util.Locale;

public class Operadores {

    public static void main(String [] args){
        
        int y = 32;
        System.out.println(y);

        System.out.println("Bom dia!");

        double x = 10.37524;
        System.out.println(x);
        System.out.printf("%.2f%n", x);
        System.out.printf("%.3f%n", x);
        Locale.setDefault(Locale.US);
        System.out.printf("%.2f%n", x);
        System.out.println("Resultado: " + x + " metros.");
        System.out.printf("Resultado: %.2f metros%n", x);

        String nome = "Ayame";
        int idade = 18;
        double renda = 4000.0;
        System.out.printf("%s tem %d anos e ganha R$ %.2f reais%n", nome, idade, renda);

    }

}
