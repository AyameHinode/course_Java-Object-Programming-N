package Classes;

import java.util.Locale;
import java.util.Scanner;

public class EntradaDadosEx2 {

    public static void main(String ... args){

        Locale.setDefault(Locale.US);

        Scanner entrada = new Scanner(System.in);

        String x;
        int y;
        double z;
        x = entrada.next();
        y = entrada.nextInt();
        z = entrada.nextDouble();

        System.out.println("Dados digitados:");
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);

    }

}
