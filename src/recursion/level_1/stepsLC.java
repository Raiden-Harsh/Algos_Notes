package recursion.level_1;
/*
Q) Count the number of steps to reduce a number to zero.The steps you can take are -
    Step1: if the number is even divide the number by 2.
    Step2: if the number is odd subtract one form it.
 */
public class stepsLC {
    public static void main(String[] args) {
        System.out.println(steps(8));
    }
    public static int steps(int n){
        return helper(n,0);
    }
    public static int helper(int n, int count){
        if(n == 0){
            return count;
        }
        if(n%2 == 0){
            return helper(n/2,count+1);
        }else {
            return helper(n-1,count+1);
        }
    }
}
