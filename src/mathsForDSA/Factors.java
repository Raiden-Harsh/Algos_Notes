package mathsForDSA;

import java.util.ArrayList;

public class Factors {
    public static void main(String[] args) {
        factors1(20);
        System.out.println();
        factors2(20);
        System.out.println();
        factors3(20);
    }
    // brute force method to find the factors!
    public static void factors1(int n){
        for (int i = 1; i <=n ; i++) {
            if(n % i == 0){
                System.out.print(i + " ");
            }
        }
    }
    // more optimised way O(sqrt(N))
    public static void factors2(int n){
        for (int i = 1; i*i <=n ; i++) {
            if(n % i == 0){
                if( n/i == i){
                    System.out.print(i + " ");
                }else {
                    System.out.print(i +" "+ n/i + " " );
                }
            }
        }
    }
    // printing in sequential order
    // both space and time complexity will be O(sqrt(N))
    public static void factors3(int n){
        ArrayList<Integer> list  = new ArrayList<>();
        for (int i = 1; i*i <=n ; i++) {
            if(n % i == 0){
                if( n/i == i){
                    System.out.print(i + " ");
                }else {
                    System.out.print(i +" ");
                    list.add(n/i);
                }
            }
        }
        for (int i = list.size()-1; i >=0 ; i--) {
            System.out.print(list.get(i) + " ");
        }
    }

}
