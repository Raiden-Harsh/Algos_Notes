package binary_search;

import java.util.Arrays;

public class RotatedBSWithDuplicateElements {

/*
Q) Find the target in the rotated sorted array!
GIVEN: Now we Will be having DUPLICATE ELEMENTS!
NOTE: example of rotated array!
arr = [1,3,5,6,7,8,9]
after one rotation in clockwise direction
arr=[9,1,3,5,6,7,8]
again rotation in clockwise direction
arr=[8,9,1,3,5,6,7]
Here the pivot is 9 as it is the largest element of the array!
 */


    public static void main(String[] args) {
        int[] rotatedArr = {2, 2, 2, 9, 2, 2, 2};
        int target = 9;
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

    //If we have duplicate elements the previous pivot method is going to get failed!

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
            /*
            NOTE: THIS MAY FAIL AS WITH DUPLICATE ELEMENTS IT IS POSSIBLE THAT
            START,END AND MID MAY POINT TO EQUAL ELEMENTS.........
            WE CAN SKIP THOSE DUPLICATE ELEMENTS
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
            */
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                //i.e. start=mid=end= same_element
                //NOTE: it is possible that start or end may be our pivots
                //we check for pivots, and then we skip them
                if (arr[start] > arr[start + 1]) {
                    //start is pivot
                    return start;
                }
                //if this is not executed i.e. start is no pivot, so we increment start by one!
                start++;
                if (arr[end] < arr[end - 1]) {
                    //end is the pivot
                    return end - 1;
                }
                end--;
            }
            //left side is sorted, so pivot should be in right!
            else if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                /*
                If start < mid i.e. left side is sorted so that the pivot must be on the right side
                but since we have duplicate elements it is also a possibility that start and middle are equal
                now if the pivot lies on the right side it should be like mid,..,pivot,...end and as the pivot
                is the largest number, so end should be smaller than the middle!
                as from mid the numbers will rise till pivot and then form pivot+1 till end it will again be an
                ascending sorted array!!
                and we also know all the elements from start to mid will be larger or equal to the end element,
                hence the middle element will be greater than the end....
                THIS IS WHY WE HAVE 2 CHECKS IN THE OR PART OF IF!!
                 */
                start = mid + 1;//pivot in right side so check in right
            } else {
                end = mid - 1;// pivot in left side so check in left!
            }
        }
        //if we are not returning anything in the while loop
        //that means we don't found our pivot
        return -1;
    }
}


