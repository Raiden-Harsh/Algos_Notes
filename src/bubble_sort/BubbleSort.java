package bubble_sort;

import java.util.Arrays;

/*
This is the code for the bubble sort algo!
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        System.out.println("Before Sort: " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("After Sort: " + Arrays.toString(arr));

    }

    static void bubbleSort(int[] arr) {
        //if the array is already sorted then
        boolean swap;
        //run the loop for n-1 times
        for (int i = 0; i < arr.length; i++) {
            swap = false; // no swap made till now
            //for each step the max item will come at the last index
            for (int j = 1; j < arr.length - i; j++) {
                //swap the item if it is smaller than the previous item
                if (arr[j] < arr[j - 1]) {
                    //then swap
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swap = true;
                }
            }
            // after one pass if no swap was done then the array is already sorted, and we break!
            if (!swap) { //when no swap then swap will be false and !false = true so our 'if' will execute!
                break;
            }
        }
    }
}
