package mathsForDSA;

public class BinarySearchSQRT {
    public static void main(String[] args) {
        int n = 40;
        int p = 3;
       // System.out.println(sqrt(n,p));
        // this will print only till 3 decimal places
        System.out.printf("%.3f",sqrt(n,p));
    }

    public static double sqrt(int n,int p){
        int start = 0;
        int end = n;
        double root = 0.0;
        // first find the integer value
        while (start <= end){
            int mid = start + (end - start)/2;
            if( mid * mid == n){
                return mid;
            }
            if(mid * mid > n){
                end = mid-1;
            }else {
                start = mid + 1;
            }
        }
        double increment = 0.1;
        for (int i = 0; i<p; i++){
            while (root * root < n){
                root += increment;
                // when this breaks our root * root will be > n, so we roll back to previous increment!
            }
            root-=increment;
            increment/=10;
        }
        return root;
    }
}
