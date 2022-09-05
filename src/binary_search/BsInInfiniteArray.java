package binary_search;
/*
Q) find the target in ascending order sorted infinite array!
INFINITE ARRAY means that we can't know the length of the array.
 */
public class BsInInfiniteArray {
    public static void main(String[] args) {
        int[] arr= {1,2,3,4,5,6,7,8,9,12,13,15,23,35,64};
        int target = 5;
        System.out.println(findAnswer(arr,target));
    }
    static int findAnswer(int[] arr,int target){
        //first we will find the range
        //we will move into small chunks and then each time we will double our chunk
        //time complexity will be O(log(N))
        int start =0;
        int end = 1;
        //condition for the target to lie in the range
        while(target> arr[end]){
            int temp = end+1;
            //temp will be our new Start
            //now we will double the chunk value i.e.
            //end = previous end + Size_of_chunk*2
            end = end + (end-start +1)*2;
            start = temp;
        }
        return binarySearch(arr,target,start,end);
    }
    static int binarySearch(int[] arr,int target,int start,int end){
        int st = start;
        int en = end;
        while (st<=en){
            int mid = st + (en-st)/2;
            if(target<arr[mid]){
                en = mid-1;
            }
            else if(target>arr[mid]){
                st=mid+1;
            }
            else
                return mid;
        }
        return -1;
    }
}
