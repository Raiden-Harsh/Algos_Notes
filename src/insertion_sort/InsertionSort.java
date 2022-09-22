package insertion_sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = {5,2,3,1,4};
        System.out.println("before sort: ");
        System.out.println(Arrays.toString(nums));
        System.out.println("After Insertion Sort:");
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));

    }

    static void insertionSort(int[] arr) {
        for (int i = 0; i <= arr.length - 2; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j);
                } else {
                    break;
                }
            }

        }
    }

    static void swap(int[] arr, int index) {
        int temp = arr[index];
        arr[index] = arr[index - 1];
        arr[index - 1] = temp;
    }
}
