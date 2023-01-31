package quick_sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 2, 3, 1};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    // The low and high will tell which part of array are we working on
    // basically what sub array are we using, left or right one
    public static void sort(int[] arr, int low, int high) {
        if (low >= high) {
            // whole array has been traversed!
            return;
        }
        // these start end will traverse the parts of the array
        // and will be used for swapping
        int start = low;
        int end = high;
        int mid = start + (end - start) / 2;
        int pivot = arr[mid];
        // we are traversing the sub-arrays
        while (start <= end) {
            // both while loops simply checks for pivot violation i.e.
            while (arr[start] < pivot) {
                start++;
            }
            while (arr[end] > pivot) {
                end--;
            }
            // this check ensures if the outer while check still hold
            // as that will be only checked when the below lines get executed,
            // so there is a possibility that it may not hold!
            if (start <= end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                // when swapping is done move the pointers forward!
                start++;
                end--;
                // the above check also ensure that if the array is already sorted it will not swap!
            }
        }
        // At this point the pivot is at the correct position
        // now the recursive calls to sort both halves of the array again!
        /*
         * After the first pass:
         *   > low is at start index : 0
         *   > high is at last index : arr.length - 1
         *   > end has come left side of the pivot
         *   > start has come right side of the pivot
         * Two new sub arrays are like-
         *   > from low to end : Left side sub array.
         *   > from start to high : Right side sub array.
         * both of these arrays can be sorted similarly.
         * */
        // LEFT ARRAY
        sort(arr, low, end);
        // RIGHT ARRAY
        sort(arr, start, high);
    }
}
