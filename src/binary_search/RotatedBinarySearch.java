package binary_search;
/*
Q) Find the target in the rotated sorted array!
GIVEN: no duplicate elements.
NOTE: example of rotated array!
arr = [1,3,5,6,7,8,9]
after one rotation in clockwise direction
arr=[9,1,3,5,6,7,8]
again rotation in clockwise direction
arr=[8,9,1,3,5,6,7]
Here the pivot is 9 as it is the largest element of the array!
 */

import java.util.Arrays;

public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] rotatedArr = {5, 6, 7, 0, 1, 2, 3, 4};
        int target = 6;
        int ans = answer(rotatedArr, target);
        System.out.println(Arrays.toString(rotatedArr));
        System.out.println("Target: " + target + " is at index: " + ans);

    }

    static int answer(int[] arr, int target) {
        //find the pivot firstly
        int pivot = findPivot(arr);

        if (pivot == -1) {
            //no pivot found i.e. array is not rotated!!!!
            //simple binary search will do the trick!
            return BinarySearch(arr, 0, arr.length - 1, target);
        }
        //If we found the pivot then we hove two ascending arrays!
        //There can be 3 cases possible
        //case 1: our target is the pivot element
        if (target == arr[pivot]) {
            return pivot;
        }
        //case 2: our target lies in the first part of the array i.e. form start to 0 to pivot
        //we know all the elements after pivot to end will be smaller than the start element if it is rotated!
        //example: [3,4,5,6,7,0,1,2] start =3 end = 2 pivot = 7
        //here all elements from pivot+1 to end are obviously smaller than the start
        if (target >= arr[0]) {
            //our target will lie in first array(form 0 to pivot -1)
            return BinarySearch(arr, 0, pivot - 1, target);
        }
        //case 3: target lies in the second array!
        else {
            return BinarySearch(arr, pivot + 1, arr.length - 1, target);
        }

    }

    static int BinarySearch(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            }
            if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            //4 possible cases for pivot
            //case 1:
            if (mid < end && arr[mid] > arr[mid + 1]) {
                //if mid is at the last element of array so mid+1 will give array out of bounds exception
                return mid;//found the answer!
            }
            //case 2:
            if (mid > start && arr[mid] < arr[mid - 1]) {
                //if mid is at start then mid-1 will also give index out of bounds exception!
                return mid - 1;//as the pivot is the biggest element!
            }
            //case 3:
            if (arr[mid] <= arr[start]) {
                //this means all the elements form middle to start are going to be less than the start
                //element so why check in that array again
                //so our new array will be from start to mid-1
                end = mid - 1;
            } else {
                //this means mid > start but this middle is not the pivot
                //because if it were then it should have caught by other cases,
                //so we have to search in the other part of the array(right side)
                start = mid + 1;
            }
        }
        //if we are not returning anything in the while loop
        //that means we don't found our pivot
        return -1;
    }
}
