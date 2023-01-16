package recursion.level_1;

public class ProductOfDigits {
    public static void main(String[] args) {
        System.out.println(prod(12304));
    }
    public static int prod(int n){
        /*
         * or we can use this base condition where we are returning the last digit
         * if(n%10 == n){
         *  return n;
         * }
         *
         */
        if(n == 0){
            return 1;
        }
        return (n%10) * prod(n/10);
    }
}
