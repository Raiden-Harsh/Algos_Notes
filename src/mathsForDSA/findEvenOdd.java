package mathsForDSA;

public class findEvenOdd {
    public static void main(String[] args) {
        int n = 56;
        System.out.println(isOdd(n));
    }

    private static boolean isOdd(int n) {
        // "&" with 1 will give the same number
        // "&" with 0 will give 0
        /*
         11001010
       & 00000001
       ------------
         00000000 -> 0 which is the last digit!
         as all the other numbers are the power of 2,so they are bound to be even but the last digit will,
         determine if the number is even or odd.
         */
        return (n & 1) ==1;
    }
}
