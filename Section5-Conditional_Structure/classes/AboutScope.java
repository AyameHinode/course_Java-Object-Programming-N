package classes;

public class AboutScope {

    public static void main(String[] args){

        double price = 600.00;
        double discount; //inicializacao

        if (price < 600.00){
            discount = price * 0.1;
        }else {
            discount = 0;
        }

        System.out.println(discount);

    }

}
