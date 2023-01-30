package recursion.patterns;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {4,3,2,66,5,7,9,1};
        ss(arr,arr.length-1,0);
        System.out.println(Arrays.toString(arr));
    }
   /*
    * row is how many times the outer loop runs
    * column is how many times the inner loop runs
    */
    public static void ss(int[] arr, int row, int column){
        if(row<0){
            return;
        }
        if(row>column){
            // we may use a helper fn to find the largestIndex element
            int largestIndex = helper(arr,0,row-column);
            // swap
            int temp = arr[largestIndex];
            arr[largestIndex] = arr[row-column];
            arr[row-column] = temp;
            ss(arr,row,column+1);
        }else {
            ss(arr,row-1,0);
        }
    }
    public static int helper(int[] arr, int start, int end){
        // return the largest index
        int max = -1;
        int pos = -1;
        for (int i = start; i <= end ; i++) {
            if(arr[i]>max){
                max = arr[i];
                pos = i;
            }
        }
        return pos;
    }
}
