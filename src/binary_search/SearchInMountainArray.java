package binary_search;

import java.util.Arrays;

/*
Q) Search the target in mountain array!
 */
public class SearchInMountainArray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 7, 4, 2, 0, -1};
        int target = 3;
        int answer = ans(arr, target);
        System.out.println(Arrays.toString(arr));
        System.out.println("target :" + target + " is at index: " + answer);

    }

    static int ans(int[] arr, int target) {
        int highestIndex = highestInMountain(arr);
        //first to search in ascending order!
        int ans = BinarySearch(arr, 0, highestIndex, target, true);
        if (ans == -1)
            ans = BinarySearch(arr, highestIndex, arr.length - 1, target, false);

        return ans;
    }

    static int BinarySearch(int[] arr, int start, int end, int target, boolean isAscending) {
        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (isAscending) {
                if (target > arr[middle])
                    start = middle + 1;
                else if (target < arr[middle])
                    end = middle - 1;
                else //target = middle
                    return middle;
            } else {
                if (target < arr[middle])
                    start = middle + 1;
                else if (target > arr[middle]) {
                    end = middle - 1;
                } else
                    return middle;
            }
        }
        //if target is not found!
        return -1;
    }

    static int highestInMountain(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                //descending order
                end = mid;
            } else {
                //ascending order
                start = mid + 1;
            }
        }

        return start;// or end as they both will be pointing to same element
    }
}

/*
APPROACH:
    > we can find the highest element of the bi-tonic array
    > we can search in left or right array by simple binary search
 */
