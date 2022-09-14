package binary_search.matrix;

import java.util.Arrays;

/*
Q) Find the element it the true sorted matrix!
NOTE: A true sorted matrix is in which last column is less than the next rows first element!
example of a true sorted matrix is :
int[][] arr = { {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
};
 */
public class TrueSortedMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int target = 8;
        // to print the whole matrix
        for (int[] a:arr) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println("Target :"+target+" \nlies at:" + Arrays.toString(search(arr,target)));
    }

    /*
    Since the array is completely sorted, we can reduce the search space by either first,
    searching in the middle row or the middle column.
    Let's say we will search for the middle column, and it is 'c'
    now our lower bound i.e. rowStart will be the first element of the array i.e. [0][c] element
    our upper bound will be the last row i.e. [arr.length - 1][c]
    our middle will be the row according to the start and end, in this example it is going to be
    0+3/2 = 1, [1][1] // as the middle column will be (0+3)/2  = 1
    Now,
    we will first try to search in the column,weather we have the answer in the column or not.
    let say our target is 8, in the middle column we will apply the binarySearch,
    our start will be [0][1] = 2, our end will be [3][1] = 14, so our middle will be [1][1] = 6
    Now we can have the following cases:
        case 1: our middle element is == target // answer found!
        case 2: our middle element > target i.e. all the elements after the middle element will also be
                greater than the target!! so can safely avoid the rows after middle
        case 3: our middle element < target i.e. all the elements up-to that middle element will also be smaller,
                so we can safely ignore the rows before middle!!
        AT LAST WE WILL BE LEFT WITH ONLY 2 ROWS,
        and these two rows can be divided into 4 parts as:
            part 1: first row left to middle.
            part 2: first row right to middle.
            part 3: second row left to middle.
            part 4: second row right to middle.
        and we can perform a simple Binary Search on these 4 parts to get our target!
     */
    static int[] search(int[][] matrix, int target) {
        int ans[] = {-1, -1};
        int rows = matrix.length;
        int columns = matrix[0].length;// just to be cautious, if matrix have only one row!
        if (rows == 1) {
            // only one row
            return binarySearch(matrix, 0, 0, columns, target);
        }
        // run the loop till only 2 rows are remaining!!
        int rowStart = 0;
        int rowEnd = rows - 1;
        int columnMid = columns / 2;
        while (rowStart < (rowEnd - 1)) {// while this is true we will have more than 2 rows
            int mid = rowStart + (rowEnd - rowStart) / 2;

            //case 1: the middle element of this column is our answer!
            if (matrix[mid][columnMid] == target) {
                //we found answer!
                return new int[]{mid, columnMid};
            }
            //case 2: element < target ( target lies in the next row, so ignore rows till mid)
            if (matrix[mid][columnMid] < target) {
                // ignore the above rows form mid!
                rowStart = mid;
            } else { // element > target (target will lie in the above row, so ignore rows after middle)
                rowEnd = mid;
            }
        }
        // now we will have only 2 rows!
        // now we check if the target lies in the middle column or not
        if(matrix[rowStart][columnMid] == target){
            return new int[] {rowStart,columnMid};
        }// now the row end will be the consecutive next row as we have 2 rows only
        if(matrix[rowStart+1][columnMid] == target){
            return new int[] {rowStart,columnMid};
        }

        // IF WE DON'T GET THE TARGET TILL NOW WE WILL SEARCH IN THE 4 HALVES OF THE MATRIX
        // searching in the 1st half
        if(target<= matrix[rowStart][columnMid -1]){
            return binarySearch(matrix,rowStart,0,columnMid-1,target);
        }
        // searching in the 2nd half
        if(target>= matrix[rowStart][columnMid+1] && target<= matrix[rowStart][matrix[rowStart].length-1]){
            // target should also be <= the final element of that row!
            return binarySearch(matrix,rowStart,columnMid+1,matrix[rowStart].length-1,target);
        }
        //search in 3rd half
        if(target<=matrix[rowStart+1][columnMid-1]){
            return binarySearch(matrix,rowStart+1,0,columnMid-1,target);
        }
        // search in the 4th half
        if(target>=matrix[rowStart+1][columnMid+1]){
            return binarySearch(matrix,rowStart+1,columnMid+1,matrix[rowStart+1].length-1,target);
        }
        return ans;
    }

    //we need to have a simple binarySearch as well
    //to search in the rows provided and to search between the columns provided!
    static int[] binarySearch(int[][] matrix, int row, int cStart, int cEnd, int target) {
        while (cStart <= cEnd) {
            int mid = cStart + (cEnd - cStart) / 2;
            //case 1 mid is the target!
            if (matrix[row][mid] == target) {
                return new int[]{row, mid};
            }
            //case 2 target > mid (target lies on right side)
            if (matrix[row][mid] < target) {
                cStart = mid + 1;
            }
            //case 3 target< mid (target lies on left side)
            else {
                cEnd = mid - 1;
            }
        }
        return new int[]{-1, -1}; // you didn't find the target!
    }

}
