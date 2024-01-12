package classes;

public class AboutStringSplit {

    static public void main(String ... args){

        String animals = "cats dogs birds fish";

        String[] vect = animals.split(" ");

        System.out.println(vect[0]);
        System.out.println(vect[1]);
        System.out.println(vect[2]);
        System.out.println(vect[3]);

    }

}
