package versions;

import java.util.Locale;
import java.util.Scanner;

public class ProgramaV1 {

    public static void main(String ... args){

        Locale.setDefault(Locale.US);
        Scanner leitor = new Scanner(System.in);
        double xA, xB, xC, yA, yB, yC;

        System.out.println("Entre com as medidas do triangulo X: ");
        xA = leitor.nextDouble();
        xB = leitor.nextDouble();
        xC = leitor.nextDouble();

        System.out.println("Entre com as medidas do triangulo Y: ");
        yA = leitor.nextDouble();
        yB = leitor.nextDouble();
        yC = leitor.nextDouble();

        double p = (xA + xB + xC) / 2.0;
        double areaX = Math.sqrt(p * (p - xA) * (p - xB) * (p - xC));

        p = (yA + yB + yC) / 2.0;
        double areaY = Math.sqrt(p * (p - yA) * (p - yB) * (p - yC));

        System.out.printf("Area do Triangulo X: %.4f%n", areaX);
        System.out.printf("Area do Triangulo Y: %.4f%n", areaY);

        if (areaX > areaY){
            System.out.println("Maior area: X");
        } else {
            System.out.println("Maior area: Y");
        }

        leitor.close();

    }

}
