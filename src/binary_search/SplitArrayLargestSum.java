package binary_search;
/*
Q) Given an array 'nums' which consists of non-negative integers and an integer m,
   you can split the array into m non-empty continuous sub arrays.
   Write an Algorithm to minimise the largest sum among these sub arrays!
 */

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] arr = {7,2,5,10,8};
        int m =2;
        System.out.println(splitArray(arr,m));


    }
    static int splitArray(int[] nums,int m){
        //This start & end are the range in which our potential answer may lie
        /*
        the smallest possible answer will be the largest element of the array,if m = size of array
        the greatest possible answer will be the sum of array if m = 1
         */
        int start =0;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start,nums[i]);//when the loop break we have max value of array in start
            end+=nums[i];
        }
        //Now we have our range of possible answer, so we apply BinarySearch to find the answer
        while (start<end){
            //try for the middle as potential answer
            int mid = start+(end-start)/2; //the sum that is allowed to us
            //calculate how many pieces you can divide it in with this given sum!!
            int sum =0;
            int pieces = 1;//min one piece will be there
            for (int num : nums) {
                if(sum+num > mid){
                    //you can't add this in this sub-array,make a new one
                    //say you add this in the new sub-array, then sum = num
                    sum = num;
                    pieces++; //one more array is created!
                }else {
                    //continue to add in the same array
                    sum += num;
                }

            }
            if(pieces>m){
                //more sub-arrays are generating then required i.e.
                //allowed sum is less, we have to increase it
                start = mid+1;
            }else{
                //less than the required pieces i.e. allowed sum should be decreased
                end = mid;
            }


        }
        return start; //in the end, start==end
    }
}