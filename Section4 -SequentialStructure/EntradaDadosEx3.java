import java.util.Scanner;

public class EntradaDadosEx3 {

    public static void main(String ... args){

        Scanner entrada = new Scanner(System.in);

        int x;
        String s1, s2, s3;

        x = entrada.nextInt();
        entrada.nextLine();
        s1 = entrada.nextLine();
        s2 = entrada.nextLine();
        s3 = entrada.nextLine();

        System.out.println("Dados digitados:");
        System.out.println(x);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        entrada.close();

    }

}
