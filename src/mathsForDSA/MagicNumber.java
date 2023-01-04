package mathsForDSA;
/*
Q) Find the n'th magic number.
   a magic number is calculated as,
   example,
   1st -> 001 => 1*5^1 = 5
   2nd -> 010 => 0*5^1 + 1*5^2 = 25
   3rd -> 011 => 1*5^1 + 1*5^2 + 0*5^3 = 30
 */
public class MagicNumber {
    public static void main(String[] args) {
        // find 6th magic number
        int n = 6;
        int ans = 0;
        int base = 5;
        while (n>0){
            int last = n & 1;
            ans = ans +(last * base);
            base *=5;
            n=n>>1;
        }
        System.out.println(ans);
    }
}
