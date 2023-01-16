package recursion.level_1;

public class CountZeros {
    public static void main(String[] args) {
        System.out.println(countZero(4090));
    }
    public static int countZero(int n){
        return helper(n,0);
    }
    // how to pass a value to above calls
    public static int helper(int n, int count){
        if(n == 0){
            return count;
        }
        if(n%10 == 0){
           return helper(n/10,count+1);
        }else {
           return helper(n/10, count);
        }
    }

}
