package binary_search;

import java.util.Arrays;

/*
Q) Find the first and last occurance of a target element in the given array!
GIVEN: array is in ascending order
 */
public class FirstAndLastOccurance {
    public static void main(String[] args) {
        int[] arr ={2,3,5,6,7,7,7,7,7,7,8,9,10};
        int target =7;
        System.out.println(Arrays.toString(searchRange(arr,target)));

    }

    static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        int start = search(nums, target, true);
        int end = search(nums, target, false);
        ans[0] = start;
        ans[1] = end;

        return ans;
    }

    static int search(int[] nums, int target, boolean isSearchingForStart) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < nums[mid])
                end = mid - 1;
            else if (target > nums[mid])
                start = mid + 1;
            else {
                //potential answer found!
                ans = mid;
                if (isSearchingForStart)
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }
        return ans;
    }
}
