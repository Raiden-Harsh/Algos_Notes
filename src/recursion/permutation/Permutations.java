package recursion.permutation;

import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
        permutation("", "abc");
        System.out.println(permutationArray("","abc"));
        System.out.println(permutationCount("","abc"));
    }

    public static void permutation(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        // since the recursive calls at each level is different
        for (int i = 0; i <= p.length(); i++) {
            // substring(start, end]
            // start is inclusive, end is exclusive
            // "smile" substring(1,3) => "mi" i.e. up-to but not including end!
            String first = p.substring(0, i);
            String second = p.substring(i, p.length());
            permutation(first + ch + second, up.substring(1));
        }
    }
    // if you want to return as an Array list

    public static ArrayList<String> permutationArray(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();

        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0, i);
            String second = p.substring(i, p.length());
            ans.addAll(permutationArray(first + ch + second, up.substring(1)));
        }
        return ans;
    }
    // if you want to return the count of the permutations
    public static int permutationCount(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }
        int count = 0;
        char ch = up.charAt(0);
        // since the recursive calls at each level is different
        for (int i = 0; i <= p.length(); i++) {
            // substring(start, end]
            // start is inclusive, end is exclusive
            // "smile" substring(1,3) => "mi" i.e. up-to but not including end!
            String first = p.substring(0, i);
            String second = p.substring(i, p.length());
            count = count + permutationCount(first + ch + second, up.substring(1));
        }
        return count;
    }

}
