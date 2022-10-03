package patterns;
/*
Print this:
 *
 **
 ***
 ****
 *****

 */
public class Qtwo {
    public static void main(String[] args) {
        pattern(5);
    }
    static void pattern(int n){
        for (int i = 1; i <=5 ; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print("* ");
            }
            // when one horizontal line /row is printed we need a new line
            System.out.println();
        }
    }
}
