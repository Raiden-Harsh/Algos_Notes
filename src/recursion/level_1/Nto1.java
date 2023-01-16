package recursion.level_1;
// print numbers form N to 1
public class Nto1 {
    public static void main(String[] args) {
        func(5);
        System.out.println();
        funRev(5);
        System.out.println();
        funBoth(5);
    }
    public static void func(int n){
        if(n == 0){
            return;
        }
        System.out.print(n + " ");
        func(n-1);
    }
    public static void funRev(int n){
        if(n == 0){
            return;
        }
        funRev(n-1);
        System.out.print(n + " ");
    }
    public static void funBoth(int n){
        if(n == 0){
            return;
        }
        System.out.print(n + " ");
        funBoth(n-1);
        System.out.print(n + " ");
    }
}
