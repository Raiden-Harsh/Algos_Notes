package recursion.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IterationSubset {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3};
        int[] arr2 = {2, 1, 2};
        List<List<Integer>> ans = new ArrayList<>();
        ans = subset(arr);
        System.out.println(ans);
        List<List<Integer>> ans2 = new ArrayList<>();
        ans2 = subsetDuplicate(arr2);
        System.out.println(ans2);

    }

    /*
     * The basic idea here is to make an outer list which will contain all the answers form,
     * each level, as list themselves.
     *
     * the basic idea is still the same, we are taking and rejecting each element,
     * the outer loop is for each element in our given arr "arr"
     *
     * then we are taking the size of the outer list,
     * one more for loop is used to copy each element in the outer list, and add the number to it.
     *
     * then this new array is added with the outer list
     * (debug at 29 for more understanding!)
     * */

    public static List<List<Integer>> subset(int[] arr) {
        List<List<Integer>> outerList = new ArrayList<>();

        outerList.add(new ArrayList<>());

        for (int num : arr) {

            int n = outerList.size();

            for (int i = 0; i < n; i++) {

                List<Integer> internalList = new ArrayList<>(outerList.get(i));

                internalList.add(num);

                outerList.add(internalList);
            }

        }

        return outerList;
    }

    // what if we have duplicate Elements.

    /*
     * -> When you find a duplicate element, only add it to the newly created subset of previous step.
     * -> this will only work if the duplicate elements are together.
     * -> to do so, sort the array!
     * */

    public static List<List<Integer>> subsetDuplicate(int[] arr) {
        // sort the array
        // this will sort the original array
        Arrays.sort(arr);

        List<List<Integer>> outerList = new ArrayList<>();

        outerList.add(new ArrayList<>());

        int start = 0;
        int end = 0;

        for (int i = 0; i < arr.length; i++) {
            start = 0;
            // if current and previous elements are same,
            // start = end + 1 (this end is the previous end)
            if (i > 0 && arr[i] == arr[i - 1]) {
                start = end + 1;
            }
            end = outerList.size() - 1;

            int n = outerList.size();

            for (int j = start; j < n; j++) {

                List<Integer> internalList = new ArrayList<>(outerList.get(j));

                internalList.add(arr[i]);

                outerList.add(internalList);
            }

        }

        return outerList;
    }


}
