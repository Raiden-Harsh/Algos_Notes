package recursion.arrays;

import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 4, 4, 4, 4};
        int target = 4;
        System.out.println(find(arr, target, 0));
        System.out.println(findAll(arr, target, 0, new ArrayList<>()));
        System.out.println("Without array list as a argument:");
        // the reason we are getting a sorted list is that we are using .addAll()
        System.out.println(findAnswerList(arr,target,0));
    }

    public static int find(int[] arr, int target, int index) {
        // boundary condition
        if (index == arr.length) {
            // index is pointing next to the last element
            return -1;
        }
        // check if you find the number
        if (arr[index] == target) {
            return index;
        }
        // if not found then check from next index
        return find(arr, target, index + 1);
    }
    /*
     *****************************************************************
     *    When you want to return all the occurrence of the target   *
     *    as an array list                                           *
     *****************************************************************
     * */

    public static ArrayList<Integer> findAll(int[] arr, int target, int index, ArrayList<Integer> list) {
        // boundary condition
        if (index == arr.length) {
            // when the traverse is complete return the ArrayList
            return list;
        }
        // if found the element update the answer list
        if (arr[index] == target) {
            list.add(index);
        }
        return findAll(arr, target, index + 1, list);
    }


    /*
    ********************************************************************
    *  If we don't want the Array List as an argument in our function  *
    *  ~~~~~~~~~~~~~~~VERY IMPORTANT CONCEPT~~~~~~~~~~~~~~~~~~~~~~~~~  *
    * ******************************************************************
    * */

    public static ArrayList<Integer> findAnswerList(int[] arr,int target, int index){
        ArrayList<Integer> onlyForThisMethodList = new ArrayList<>();
        // Boundary condition
        // if the index is more than array length then return the answer
        if(index == arr.length){
            return onlyForThisMethodList;
        }
        // if we found our target then add it in this method list only
        if (arr[index] == target) {
            onlyForThisMethodList.add(index);
        }
        // if both of these conditions are not met, that means
        // we don't find the target, and we have to search for the next indexes

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
        ArrayList<Integer> answersFromBelow = findAnswerList(arr,target,index+1);
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

        /*
        * When we reach to line 69 we will have a recursive call of the same function,
        * that is the same method will call, again and again with the different index parameter(as its index+1).
        * so for each method all lines till 69 will be executed again and again,
        * for each call we will have a new array list
        * and for these calls if we get the target we will have a single element in that list
        * now we have to take all these answers and add them in the upper lists and finally return the list
        * */

        /*
        * Now the code will be like -
        * when we get to the boundary condition, we will get a list
        * and with our example will get a single list with 13 value
        * and then next code line will execute that will add the answer
        * in "onlyForThisMethodList" and then that list will return due to the return statement
        * then we will get above call at line 69(Nice!)
        * then we similarly get all the answers returned to the main method form which this is called.
        * */
        onlyForThisMethodList.addAll(answersFromBelow);
        return onlyForThisMethodList;
    }

}
