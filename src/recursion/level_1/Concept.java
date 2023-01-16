package recursion.level_1;

public class Concept {
    public static void main(String[] args) {
        func(5);
    }
    public static void func(int n){
        if(n == 0){
            return;
        }
        System.out.println(n);
      //  func(n--);
        /*
         * The above line of code will the stack overflow error.
         * as n-- means it will FIRST PASS THE VALUE OF N THEN SUBTRACT IT
         * and --n means it will FIRST SUBTRACT THE VALUE OF N THEN PASS THE VALUE.
         * that is the reason why func(--n) is working and func(n--) is giving the stack overflow error!
         */
        func(--n);
    }
}
