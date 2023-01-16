package recursion.level_1;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(palindrome(123321));
    }
    public static boolean palindrome(int n){
        return (reverse2(n) == n);
    }
    public static int reverse2(int n) {
        // sometimes we need other variables in the argument so for that,
        // we can create helper functions

        // to find the digits of the number we can use this formula.
        int digits = (int) (Math.log10(n) + 1);
        return helper(n, digits);
    }
    private static int helper(int n, int digits) {
        // if a number is a one digit, then return it
        if (n % 10 == n) {
            return n;
        }
        int remainder = n % 10;

        return remainder * (int) (Math.pow(10, digits - 1)) + helper(n / 10, digits - 1);
    }
}
