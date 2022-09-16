package selection_sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {1,5,2,3,4};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));

    }
    static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            //find the max item in the array and swap it  to it's correct index
            int lastIndex = arr.length -i -1; //after each pass last index will be one less
            int maxItemIndex = maxIndex(arr,lastIndex);
            swap(arr,lastIndex,maxItemIndex);
        }
    }

     static void swap(int[] arr, int lastIndex, int maxItemIndex) {
        int temp = arr[lastIndex];
        arr[lastIndex] = arr[maxItemIndex];
        arr[maxItemIndex] = temp;
    }

    static int maxIndex(int[] arr,int lastIndex) {
        int max = 0;
         for (int i = 0; i <= lastIndex; i++) {
             if(arr[max]<arr[i]){
                 max = i;
             }
         }
         return max;
    }
}
