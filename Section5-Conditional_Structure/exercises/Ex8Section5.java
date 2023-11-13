package exercises;

import java.util.Scanner;

public class Ex8Section5 {

    public static void main(String ... args){

        Scanner entrada = new Scanner(System.in);
        double salario = entrada.nextDouble();
        double imposto;

        if(salario >= 0 && salario <= 2000.00){
            System.out.println("Isento");
        } else if(salario >= 2000.01 && salario <= 3000.00){
            imposto = (salario - 2000) * 0.08;
            System.out.printf("%.2f", imposto);
        } else if(salario >= 3000.01 && salario <= 4500.00){
            imposto = (1000 * 0.08) + ((salario - 3000) * 0.18);
            System.out.printf("%.2f", imposto);
        } else if(salario > 4500.00){
            imposto = (1000 * 0.08) + (1500 * 0.18) + ((salario - 4500.00) * 0.28);
            System.out.printf("%.2f", imposto);
        } else {
            System.out.println("Salario digitado inválido");
        }

        entrada.close();

    }

}
