package linear_search;

public class Main {
    public static void main(String[] args) {
        int[] nums ={1,2,5,6,23,45,-23,-35,9,34};
        int target = 9;
        int ans = linearSearch(nums,target);
        System.out.println(ans);

    }

    static int linearSearch(int[] arr, int target){
        if(arr.length == 0){
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target){
                return i;
            }

        }
        return -1;
    }
}
