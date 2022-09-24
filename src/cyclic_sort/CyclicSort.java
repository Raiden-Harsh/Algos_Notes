package cyclic_sort;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {3,2,1,5,4};
        System.out.println("Before sorting: ");
        System.out.println(Arrays.toString(arr));
        System.out.println("After Cycle Sort: ");
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));

    }
    static void cyclicSort(int[] arr){
        int i = 0;
        boolean run = true;
        // no need for a check of empty array as it should have all numbers form 1 to N!
        while (run){
            if(i == arr.length -1){
                // checking last element is unnecessary!
                //here we break the loop in style 🤣
                run = false;
            }
            if(i == arr[i] -1 ){
                //element at correct position!
                i++;
            }else {
                //ith element is not at its correct index, so we swap it!
                swap(arr,i,arr[i]-1);
            }
        }

    }
    static void swap(int[] arr, int first, int second){
        //swap first with second
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
