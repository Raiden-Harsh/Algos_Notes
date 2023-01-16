package recursion.level_1;

public class Reverse {
    public static void main(String[] args) {
        reverse1(123456);
        System.out.println(sum);
        System.out.println(reverse2(1234));
    }

    public static int sum = 0;

    public static void reverse1(int n) {
        if (n == 0) {
            return;
        }
        int reminder = n % 10;
        sum = sum * 10 + reminder;
        reverse1(n / 10);
    }
    // This is the other method to do the reverse, without changing the global variable.

    public static int reverse2(int n) {
        // sometimes we need other variables in the argument so for that,
        // we can create helper functions

        // to find the digits of the number we can use this formula.
        int digits = (int) (Math.log10(n) + 1);
        return helper(n, digits);
    }

    // we can create helper functions like this to get the variables we need
    private static int helper(int n, int digits) {
        // if a number is a one digit, then return it
        if (n % 10 == n) {
            return n;
        }
        int remainder = n % 10;

        return remainder * (int) (Math.pow(10, digits - 1)) + helper(n / 10, digits - 1);
    }
}
