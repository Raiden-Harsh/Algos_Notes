package recursion.string;

import java.util.ArrayList;

public class SubsetAndSubsequence {
    public static void main(String[] args) {
        subsequence("", "abc");
        System.out.println(subsequenceArrayList("", "abc"));
    }

    public static void subsequence(String processed, String unProcessed) {
        if (unProcessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        char ch = unProcessed.charAt(0);
        subsequence(processed + ch, unProcessed.substring(1));
        subsequence(processed, unProcessed.substring(1));
    }

    // if we want to return an array list without passing in the argument
    public static ArrayList<String> subsequenceArrayList(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            if (!processed.isEmpty()) {
                list.add(processed);
            }
            return list;
        }
        char ch = unprocessed.charAt(0);
        ArrayList<String> left = subsequenceArrayList(processed, unprocessed.substring(1));
        ArrayList<String> right = subsequenceArrayList(processed + ch, unprocessed.substring(1));
        left.addAll(right);

        return left;
    }
}
