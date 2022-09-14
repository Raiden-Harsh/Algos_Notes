package binary_search.matrix;
/*
Q) Search for the target in row wise and column wise sorted matrix!

example of row and column wise matrix is:
arr[][] = { {10,20,30,40},
            {15,25,35,45},
            {28,29,37,49},
            {33,34,38,50}
};
HERE, the rows are sorted and the columns are sorted as well!
 */

import java.util.Arrays;

public class RandCSortedMatrix {
    public static void main(String[] args) {
       int arr[][] = {  {10,20,30,40},
                        {15,25,35,45},
                        {28,29,37,49},
                        {33,34,38,50}
        };
       int target = 37;
        // to print the complete 2D matrix
        for (int[] rowArray: arr) {
            System.out.println(Arrays.toString(rowArray));
        }
        System.out.println("Target element :"+target +" in the above array lies at: "
                + Arrays.toString(searchInMatrix(arr,target)));

    }
    /*
    Here we will first create a lower bound and an upper bound
    the lb is obviously [0][0] element of the matrix
    and the ub is [0][3] element i.e. the final element of the first row (last column)
    now we may have some cases
    case1: the target == element we are at i.e. answer found return that
    case2: the target<upper bound i.e. all the element in that column are going to be larger than the target,
           as the array is sorted column wise as well!
           so it is of no need to search there!! hence, our upper bound will shift to left
           new upper bound [row][col - 1]
    case3: the target> upper bound i.e. all the elements in that row up-to that upper bound is going to
           be smaller than the target, so we can safely avoid that row!
           new upper bound[row+1][col]
    finally the loop will break when there are no elements left i.e. row will be > length of matrix
    and column are -1,
    or we can say the loop will run till, the row is less than the length of array and the column is >=0;
     */
    static int[] searchInMatrix(int[][] arr, int target){
        int[] ans = {-1,-1};
        int r = 0;
        int c = arr.length-1; // arr.length will give the number of rows in the array!
        while(r<arr.length && c>=0){
            //check 1
            if(target == arr[r][c]){
                //answer found
                return new int[] {r,c};
            }
            //check 2
            if(target>arr[r][c]){
                // no need to check in that row
                r++;
            }
            else {
                // target< arr[r][c] i.e. no need to check in that column
                c--;
            }
        }
        return ans;
    }
}
