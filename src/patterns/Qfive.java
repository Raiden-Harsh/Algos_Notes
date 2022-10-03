package patterns;
/*
Print this:(n = 5)
    *
    **
    ***
    ****
    *****
    ****
    ***
    **
    *

 */

public class Qfive {
    public static void main(String[] args) {
        pattern(5);

    }
    static void pattern(int n){
        for (int i = 0; i < (2*n)-1; i++) {
            int col;
            if(i<n){
               col = i;
            }else{
                col =(2*n)-i-2;
            }

            for (int j = 0; j <col+1 ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }
}
