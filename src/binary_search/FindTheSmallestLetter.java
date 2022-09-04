package binary_search;

import java.util.Arrays;

/*
 * Q) Find the smallest character in the given array which is larger than the target.
 * NOTE: characters wrap around i.e. IF THE TARGET IS THE BIGGEST ELEMENT RETURN THE FIRST ELEMENT.
 * GIVEN: char array is ascending sorted!
 *        all characters are lowercase!
 */
public class FindTheSmallestLetter {
    public static void main(String[] args) {
        char[] arr = {'b', 'd', 'f', 'l'};
        char target = 'z';
        System.out.println("The smallest character larger then the target: " + target + " in the given array:");
        System.out.println(Arrays.toString(arr));
        int ans = findTheSmallestChar(arr, target);
        System.out.println(arr[ans]);

    }

    static int findTheSmallestChar(char[] arr, char target) {
        int start = 0;
        int end = arr.length - 1;
        //for the wrap around condition check
        if (target >= arr[arr.length - 1])
            return 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else
                return start;

        }
        return start;
    }
}
