package classes;

public class StringFunctions {

    static public void main(String ... args){

        String original = "Cats can sleep   .....Love Cats!      ";

        String s1 = original.toLowerCase();
        String s2 = original.toUpperCase();
        String s3 = original.trim();
        String s4 = original.substring(2);
        String s5 = original.substring(2, 9);
        String s6 = original.replace('e', 'i');
        String s7 = original.replace("Cats", "Dogs");
        int i = original.indexOf("at");
        int j = original.lastIndexOf("at");

        System.out.println("Original: -" + original + "-");
        System.out.println("toLowerCase: -" + s1 + "-");
        System.out.println("toUpperCase: -" + s2 + "-");
        System.out.println("trim: -" + s3 + "-");
        System.out.println("substring(2): -" + s4 + "-");
        System.out.println("substring(2, 9): -" + s5 + "-");
        System.out.println("replace('e', 'i'): -" + s6 + "-");
        System.out.println("replace('Cats', 'Dogs'): -" + s7 + "-");
        System.out.println("Index of 'at': " + i);
        System.out.println("Last index of 'at': " + j);

    }

}
