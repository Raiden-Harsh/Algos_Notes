package linear_search;
//return the number of elements which contains even number of digits!
public class Leet_EvenDigits {
    public static void main(String[] args) {
        int[] arr = {1,54,456,-22,0};
        System.out.println(even(arr));
    }

    static int even(int[] arr){
        int count = 0;
        for(int element : arr) {
            if (count_digits(element) % 2 == 0) {
                count++;
            }
        }
        return count;
    }
    //or we could have cheated and added element+"" that would convert it into a string!!
    // then with element.length we could have found the number of digits!
    //or we could use Math.log10(element) + 1;
    static int count_digits(int element){
        int digits =0;
        if(element<0){
            element = element*-1;
        }
        //fake git commit!

        if(element == 0)
            return 1;
        while(element>0){
            digits++;
           element= element/10;
        }
        return digits;
    }
}
