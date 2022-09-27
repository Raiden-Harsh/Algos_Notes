package string;

import java.util.ArrayList;

public class PrettyPrinting {
    public static void main(String[] args) {
        float a = 11.1254534534f;
        //we want to print till 2 decimal numbers
        //here % is the placeholder, .2f is used to show two digits after decimal, and f is for float.
        System.out.printf("Formatted Number is %.2f",a);
        System.out.println();
        //value of pi till 3 digits
        System.out.println(Math.PI);

        System.out.printf("Value of Pi : %.3f",Math.PI);
        System.out.println();
        // we can have so many placeholders
        System.out.printf("Hello %s","World!");
        System.out.println();
        // when using character they are converted into ASCII value but Strings are concatenated
        // NOTE: '+' is only defined for primitives or if one operand is a String
        System.out.println('a'+'b'); // integer value
        System.out.println("a" + "b"); // ab as string
        System.out.println('a' + 3); // d (as in ASCII)
        System.out.println((char)('a'+3));// d character
        System.out.println("a"+1); // a1 as a string
        //the int 1 will convert to Integer 1 and .toString() will be called,
        //which then gives "1" string, and it is concatenated at the end
        System.out.println("Harsh" + new ArrayList<>()); // Harsh[] (as the .toString of Array List will give [])
        //This will give boxing warning
        //System.out.println("Harsh" + new Integer(7));// Harsh7 (here, .toString of Integer is called)
    }
}
