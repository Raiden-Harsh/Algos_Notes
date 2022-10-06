package patterns;
/*
print this:
            1
          2 1 2
        3 2 1 2 3
      4 3 2 1 2 3 4
    5 4 3 2 1 2 3 4 5

NOTE: whenever given numbers, try not to use 0 to n for outer loop so that we can use the numbers directly
 */

public class Qthirty {
    public static void main(String[] args) {
        pattern(5);

    }
    static void pattern(int n){
        for (int i = 1; i <=n ; i++) {
            //find the spaces
            int space=n-i;
            for (int k = 1; k <=space ; k++) {
                //add 2 spaces to accommodate for left and right spaces
                System.out.print("  ");
            }
            //first print left side
            for (int j = i; j >=1 ; j--) {
                System.out.print(j+" ");
            }
            //now right side
            for (int j = 2; j <=i ; j++) {
                System.out.print(j);
                System.out.print(" ");
            }
            //new line
            System.out.println();
        }

    }
}
