package patterns;
/*
Print this:
         4 4 4 4 4 4 4
         4 3 3 3 3 3 4
         4 3 2 2 2 3 4
         4 3 2 1 2 3 4
         4 3 2 2 2 3 4
         4 3 3 3 3 3 4
         4 4 4 4 4 4 4

 HINT:
0 0 0 0 0 0 0 0 0
0 1 1 1 1 1 1 1 0
0 1 2 2 2 2 2 1 0
0 1 2 3 3 3 2 1 0
0 1 2 3 4 3 2 1 0
0 1 2 3 3 3 2 1 0
0 1 2 2 2 2 2 1 0
0 1 1 1 1 1 1 1 0
0 0 0 0 0 0 0 0 0

 */

public class QthirtyOne {
    public static void main(String[] args) {
        pattern(4);
    }

    static void pattern(int n) {
        int orignalN = n;
        n = 2 * n;

        // at each index the value should be minimum from all the 4 walls

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                //min value form up, down , left, right
                int atEveryIndex = Math.min(Math.min(i, j), Math.min(n - i, n - j));
              //  System.out.print(atEveryIndex + " ");
                System.out.print((orignalN - atEveryIndex)+" " );
            }
            System.out.println();
        }
    }
}
