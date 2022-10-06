package patterns;
/*
Draw this:
         *
        * *
       * * *
      * * * *
     * * * * *
      * * * *
       * * *
        * *
         *
 */

public class QtwentyEight {
    public static void main(String[] args) {
        pattern(5);

    }
    static void pattern(int n){
        for (int i = 0; i < (2*n)-1; i++) {
            //find no of columns
            int col;
            if(i<n){
                col = i+1;
            }else{
                col =(2*n)-i-1;
            }
            //find the spaces and print them before each row
            int spaces = n - col;
            for (int k = 0; k < spaces; k++) {
                System.out.print(" ");
            }

            for (int j = 0; j < col; j++) {
                System.out.print("* ");
            }
            // give a new line!
            System.out.println();
        }
    }
}
