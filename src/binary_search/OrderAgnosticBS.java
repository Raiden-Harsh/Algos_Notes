package binary_search;

/*
When we don't know if the array is Ascending or Descending order!
*/
public class OrderAgnosticBS {
    public static void main(String[] args) {
        int[] arrDesc={123,98,44,39,23,22,13,6,2,0,-12,-25,-66};
        int[] arrAsec={-66,-25,-12,0,2,6,13,22,23,39,44,98,123};
        int target = 13;
        int ans = OrderAgnosticBinarySearch(arrAsec,target);
        System.out.println("The target is at: "+ans);

    }

    static int OrderAgnosticBinarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int middle = start + (end - start) / 2;

        //check if the array is ascending or descending
        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            if (target == arr[middle]) {
                return middle;
            }
            if (isAsc) {
                if (target < arr[middle]) {
                    end = middle - 1;
                } else
                    start = middle + 1;
            } else {
                if (target > arr[middle]) {
                    end = middle - 1;
                } else
                    start = middle + 1;
            }
        }
        return -1;
    }
}
