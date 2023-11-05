import java.util.Locale;
import java.util.Scanner;

public class EntradaDadosEx1 {

    public static void main(String[] args){

        Locale.setDefault(Locale.US);

        Scanner entrada = new Scanner(System.in);

        String x = entrada.next();
        System.out.println("String digitada: " + x);

        int z = entrada.nextInt();
        System.out.println("Número inteiro digitado: " + z);

        double a = entrada.nextDouble();
        System.out.printf("Número de ponto flutuante digitado: %.2f", a);

        char y = entrada.next().charAt(0);
        System.out.println("Primeiro caractere digitado: " + y);

        entrada.close();

    }

}
