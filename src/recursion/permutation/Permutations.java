package recursion.permutation;

public class Permutations {
    public static void main(String[] args) {
        permutation("", "abc");
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
}
