package mathsForDSA;

public class GCD_LCM {
    public static void main(String[] args) {
        System.out.println("H.C.F : "+gcd(5,9));
        System.out.println("L.C.M : "+ lcm(5,9));

    }
    //Euclidean Algorithm for finding HCF/GCD
    /*
    gcd(a,b) = gcd(remainder(a,b), a)
     */
    public static int gcd(int a, int b){
        if(a == 0){
            return b;
        }
        return gcd(b%a,a);
    }
    public static int lcm(int a, int b){
        return a*b/gcd(a,b);
    }

}
