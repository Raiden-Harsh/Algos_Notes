package cyclic_sort;
/*
Q) You have a set of integers s, which originally contains all the elements form [1,n].Somehow one of the
   number in the array got duplicated to another number in the set,which results in repetition of one,
   and loss of another number!
   You are given an integer array nums to represent the data status of this set after the error!
   Find the number that appears twice and the number that is missing in the form of an array.
 */

import java.util.ArrayList;
import java.util.Arrays;

public class SetMismatch {
    public static void main(String[] args) {
        int[] nums = {1,2,2,4};
        System.out.println(Arrays.toString(nums));
        System.out.println("Duplicate and Missing numbers: ");
        System.out.println(ans(nums));
    }
    static ArrayList<Integer> ans(int[] arr){
        cyclicSort(arr);
        ArrayList<Integer> a = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
           if(i != arr[i]-1){
               //the number that is duplicated
               a.add(arr[i]);
               //the number that is missing
               a.add(i+1);
           }

        }

        return a;
    }
    static void cyclicSort(int[] arr){
        int i=0;
        while (i<arr.length){
            int correctIndex = arr[i] -1;
            if(arr[i]!=arr[correctIndex]){
                swap(arr,i,correctIndex);
            }else {
                i++;
            }
        }

    }
    static void swap(int[] arr,int first,int second){
        int temp  = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;

    }
}
