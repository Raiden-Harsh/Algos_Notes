package recursion;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(6));
    }
    static int fibonacci(int n){
        //base condition
        if(n<2){
            return n;
        }
        //this is called as recursive relation!
        return fibonacci(n-1)+fibonacci(n-2);
    }
}
