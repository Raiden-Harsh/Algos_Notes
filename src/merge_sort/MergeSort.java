package merge_sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {2, 35, 56, 12, 1, 545};
        int[] arr2 = {5,4,3,2,1};
        // we are modifying the original array
        arr = mergeSort(arr);
        System.out.println(Arrays.toString(arr));
        mergeSortInplace(arr2,0,arr2.length);
        System.out.println(Arrays.toString(arr2));

    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int mid = arr.length / 2;
        // we will make two different arrays for left and right
        // copyOfRange will have inclusive length
        // everytime a new copy of the original array is passed
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        // merge both arrays
        return merge(left, right);
    }

    private static int[] merge(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length];

        int firstPointer = 0;
        int secondPointer = 0;
        int mixPointer = 0;

        // this loop will terminate when any one of the array is ended
        while (firstPointer < first.length && secondPointer < second.length) {
            if (first[firstPointer] < second[secondPointer]) {
                mix[mixPointer] = first[firstPointer];
                ++firstPointer;
            } else {
                mix[mixPointer] = second[secondPointer];
                ++secondPointer;
            }
            mixPointer++;
        }
        // it may be possible one of the arrays is not complete yet
        // add the remaining elements
        while (firstPointer < first.length) {
            mix[mixPointer] = first[firstPointer];
            firstPointer++;
            mixPointer++;
        }
        while (secondPointer < second.length) {
            mix[mixPointer] = second[secondPointer];
            secondPointer++;
            mixPointer++;
        }
        return mix;
    }

    // we can do the merge sort without making a new array everytime
    public static void mergeSortInplace(int[] arr, int s, int e) {
        if (e - s == 1) {
            return;
        }
        int mid = (s + e) / 2;

        mergeSortInplace(arr, s, mid);
        mergeSortInplace(arr, mid, e);
        // merge both arrays
        merge2(arr, s, e, mid);
    }

    private static void merge2(int[] arr, int s, int e, int mid) {
        int[] mix = new int[e - s];

        int firstPointer = s;
        int secondPointer = mid;
        int mixPointer = 0;

        // this loop will terminate when any one of the array is ended
        while (firstPointer < mid && secondPointer < e) {
            if (arr[firstPointer] < arr[secondPointer]) {
                mix[mixPointer] = arr[firstPointer];
                ++firstPointer;
            } else {
                mix[mixPointer] = arr[secondPointer];
                ++secondPointer;
            }
            mixPointer++;
        }
        // it may be possible one of the arrays is not complete yet
        // add the remaining elements
        while (firstPointer < mid) {
            mix[mixPointer] = arr[firstPointer];
            firstPointer++;
            mixPointer++;
        }
        while (secondPointer < e) {
            mix[mixPointer] = arr[secondPointer];
            secondPointer++;
            mixPointer++;
        }
        // now we have our answer in mix
        // now we change the main array
        for (int i = 0; i <mix.length ; i++) {
            arr[s+i] = mix[i];
        }
    }

}
