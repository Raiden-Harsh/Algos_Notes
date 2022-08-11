package linear_search;

public class Find_Mini {
    public static void main(String[] args) {
        int[] array ={1,5,32,3,34};
        System.out.println(min(array));
    }
    static int min(int[] arr){
        int min = arr[0];
        for (int i = 1; i <arr.length ; i++) {
            if(arr[i]<min){
                min=arr[i];
            }
        }
        return min;
    }
}
