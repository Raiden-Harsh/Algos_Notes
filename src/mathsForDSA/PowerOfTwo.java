package mathsForDSA;

public class PowerOfTwo {
    public static void main(String[] args) {
        int n = 15;
        boolean ans = false;
        ans = (n & (n-1)) == 0 ? true : false;
        System.out.println(ans);
    }
}
