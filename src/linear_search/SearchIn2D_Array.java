package linear_search;

import java.util.Arrays;

public class SearchIn2D_Array {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 5, 6, 73},
                {23, 645, 64, 767},
                {2, 8}
        };
        int target = 8;
        int[] ans = search(arr,target);
        System.out.println(Arrays.toString(ans));
    }
   static int[] search(int[][] arr ,int target){
       for (int row = 0; row < arr.length; row++) {
           for (int col = 0; col <arr[row].length; col++) {
               if(arr[row][col] == target){
                   return new int[]{row,col};
               }

           }

       }
       return new int[]{-1,-1};
   }


}
