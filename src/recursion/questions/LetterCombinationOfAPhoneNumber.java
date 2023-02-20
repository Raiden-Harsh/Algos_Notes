package recursion.questions;
/*
 * Q) Given a string containing letters form 2-9 inclusive, return all possible letter combination,
 * that the number could represent. Return the answer in any order.
 * A mapping of digit to letters is just like on a mobile phone.
 * 1(~)    2(abc) 3(def)
 * 4(ghi)  5(jkl) 6(mno)
 * 7(pqrs) 8(tuv) 9(wxyz)
 *
 * example:
 * input = "23"
 * output = ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * -----------------
 * input = "2"
 * output = ["a","b","c"]
 * (when we press 2 one time we get 'a', two time we get 'b'... )
 * */

import java.util.ArrayList;

public class LetterCombinationOfAPhoneNumber {
    public static void main(String[] args) {
        System.out.println(solution("", "23"));
        System.out.println(solutionCount("", "23"));
    }

    public static ArrayList<String> solution(String p, String up) {
        // when up is empty we found one of our potential answer
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> answer = new ArrayList<>();
        // now we need to run the loop to check for the digits
        // this will convert '2' to 2
        int digit = up.charAt(0) - '0';

        int start = (digit - 2) * 3;
        // end is exclusive
        int end = (digit - 1) * 3;
        if (digit == 8 || digit == 9) {
            start += 1;
        }
        if (digit == 7 || digit == 8 || digit == 9) {
            end += 1;
        }
        for (int i = start; i < end; i++) {
            char ch = (char) ('a' + i);
            answer.addAll(solution(p + ch, up.substring(1)));
        }
        return answer;
    }

    // if you want to return the count
    public static int solutionCount(String p, String up) {
        // when up is empty we found one of our potential answer
        if (up.isEmpty()) {
            return 1;
        }
        int localCount = 0;
        // now we need to run the loop to check for the digits
        // this will convert '2' to 2
        int digit = up.charAt(0) - '0';

        int start = (digit - 2) * 3;
        // end is exclusive
        int end = (digit - 1) * 3;
        if (digit == 8 || digit == 9) {
            start += 1;
        }
        if (digit == 7 || digit == 8 || digit == 9) {
            end += 1;
        }
        for (int i = start; i < end; i++) {
            char ch = (char) ('a' + i);
            localCount = localCount + solutionCount(p + ch, up.substring(1));
        }
        return localCount;
    }


}
