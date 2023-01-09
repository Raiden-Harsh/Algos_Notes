package mathsForDSA;

public class NewtonSQRT {
    public static void main(String[] args) {
        int n = 40;
        System.out.printf("%.3f",sqrt(n));
    }
    /*
    the Newton Raphson formula is :
    root = (X + (N/X))/2;
    where,
        root -> actual root
        X -> closest guessed answer
        N -> number whose root is to be found.

        error = |root - X|
        the smaller the error the closest the value of root is to the exact value.
     */
    public static double sqrt(double n){
        double x = n;
        double root;
        while (true){
            root = 0.5 * (x + (n/x));
            if(Math.abs(root-x) < 0.5){
                break;
            }
            x = root;
        }
        return root;
    }
}
