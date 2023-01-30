package recursion.arrays;

public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] rotatedArr = {5, 6, 7, 8, 9, 1, 2, 3};
        int target = 2;
        System.out.println(search(rotatedArr, target, 0, rotatedArr.length));
    }

    public static int search(int[] arr, int target, int start, int end) {
        //when we don't find the target
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        // when you find the target
        if (arr[mid] == target) {
            return mid;
        }
        // if the first part is sorted
        if (arr[start] <= arr[mid]) {
            //now we have to check if the target lies in this part
            if (target >= arr[start] && target <= arr[mid]) {
                // target lies in this part
                return search(arr, target, start, mid - 1); // we use return here to pass the index to above calls
            } else {
                // target lies in the second half
                return search(arr, target, mid + 1, end);
            }
        }
        // if the first part is not containing the target
        if (target >= arr[mid] && target <= arr[end]) {
            return search(arr, target, mid + 1, end);
        }
        // if not in the right then left
        return search(arr, target, start, mid - 1);
    }
}
