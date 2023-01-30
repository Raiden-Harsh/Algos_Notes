package recursion.patterns;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {4,3,2,1};
        bs(arr,arr.length-1,0);
        System.out.println(Arrays.toString(arr));
    }
    public static void bs(int[] arr,int row, int column){
        if(row<0){
            return;
        }
        if(row>column){
            if(arr[column] > arr[column+1]){
                //swap
                int temp = arr[column];
                arr[column] = arr[column+1];
                arr[column+1] = temp;
            }
            bs(arr,row,column+1);

        }bs(arr,row-1,0);
    }
}
