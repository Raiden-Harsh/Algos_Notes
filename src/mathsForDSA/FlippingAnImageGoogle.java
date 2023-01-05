package mathsForDSA;
/*
Q) Flip a binary image and invert it.
example:
[0,1,1],            [1,1,0],               [0,0,1],
[1,0,1], --Flip-->  [1,0,1], --Invert-->   [0,1,0],
[0,0,0]             [0,0,0]                [1,1,1]
 */

import java.util.Arrays;

public class FlippingAnImageGoogle {
    public static void main(String[] args) {
        int[][] arr = {{0,1,1},
                      {1,0,1},
                      {0,0,0} };
        System.out.println(Arrays.deepToString(flipAndInvertImage(arr)));

    }
    public static int[][] flipAndInvertImage(int[][] image){
        for(int[] row: image){
            //reverse this array
            for(int i = 0; i<row.length + 1/2;i++){
                //swap
                int temp = row[i] ^ 1;
                row[i] = row[image.length -i -1] ^ 1;
                row[image[0].length -i -1] = temp;
            }
        }
        return image;
    }
}
