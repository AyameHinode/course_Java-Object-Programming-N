public class FuncoesMatematicas {

    public static void main(String[] args){

        double x = 4.0;
        double y = 5.0;
        double z = 2.0;
        double a = -5.0;
        double A, B, C;

        A = Math.sqrt(x);
        B = Math.sqrt(y);
        C = Math.sqrt(4.0);
        System.out.println("Raiz quadrada de " + x + " = " + A);
        System.out.println("Raiz quadrada de " + y + " = " + B);
        System.out.println("Raiz quadrada de 4" + " = " + C);

        A = Math.pow(x, z);
        B = Math.pow(y, z);
        C = Math.pow(z, y);
        System.out.println(x + " elevado a " + z + " = " + A);
        System.out.println(y + " elevado a " + z + " = " + B);
        System.out.println(z + " elevado a " + y + " = " + C);

        A = Math.abs(x);
        B = Math.abs(a);
        System.out.println("Valor absoluto de " + x + " = " + A);
        System.out.println("Valor absoluto de " + a + " = " + B);

    }

}
