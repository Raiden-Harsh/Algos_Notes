package cyclic_sort;
/*
Q) Given an integer array nums of length n, where all the integers of the array are in the range [1,n]
   and each integer appears once or twice, return the array of all the numbers that appear twice!

   You must write an algorithm that runs in O(N) time complexity and take O(1) constant space.
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FindAllDuplicatesInTheArray {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(Arrays.toString(nums));
        System.out.println("Duplicate elements are :");
        System.out.println(ans(nums));
    }
    static ArrayList<Integer> ans(int[] arr){
        cycleSort(arr);
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]-1 != i){
                a.add(arr[i]);
            }
        }
        // we have an arraylist that contain our extra elements!
        Collections.sort(a);

        return a;
    }
    static void cycleSort(int[] arr){
        int i =0;
        while (i<arr.length){
            // correct index for arr[i] element!
            int correctIndex = arr[i]-1;
            if(arr[i] != arr[correctIndex]){
                swap(arr,i,correctIndex);
            }else {
                i++;
            }
        }
    }
    static void swap(int[] arr, int first,int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
