package mathsForDSA;
/*
Q) Given an array with the number repeating in pairs, find the unique number in
   constant time complexity O(n).
 */

public class FindUnique {
    public static void main(String[] args) {
        int arr[] = {2,2,3,3,4,4,5,5,6};
        System.out.println(ans(arr));
    }
    public static int ans(int[] arr){
        int unique = 0;
        for(int n : arr){
            unique ^=n;
        }
        return unique;
    }
}
