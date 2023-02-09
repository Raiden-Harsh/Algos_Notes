package recursion.string;

import java.util.ArrayList;

public class Ascii {
    public static void main(String[] args) {
        // to get the Ascii value of a character
        char ch = 'a';
        System.out.println(ch + 0);

        System.out.println(subsetAcii("", "abc"));
    }
    /*
     * Q) Print all the subsets with its Ascii value.
     */

    public static ArrayList<String> subsetAcii(String processed, String unProcessed) {
        if (unProcessed.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        char ch = unProcessed.charAt(0);

        ArrayList<String> left = subsetAcii(processed + ch, unProcessed.substring(1));
        ArrayList<String> right = subsetAcii(processed, unProcessed.substring(1));
        ArrayList<String> ascii = subsetAcii(processed + (ch + 0), unProcessed.substring(1));

        left.addAll(right);
        left.addAll(ascii);

        return left;
    }
}
