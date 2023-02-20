package recursion.questions;
/*
 * Q) Given a number n, find out all the possible combination in a dice, whose
 * combination will give their sum as n.
 *
 * */

import java.util.ArrayList;

public class Dice {
    public static void main(String[] args) {
        diceCombination("", 4);
        System.out.println(diceCombinationList("", 4));
        System.out.println(diceFace("",4,3));
    }

    public static void diceCombination(String p, int target) {
        if (target == 0) {
            System.out.println(p);
            return;
        }
        for (int i = 1; i <= 6 && i <= target; i++) {
            diceCombination(p + i, target - i);
        }
    }

    public static ArrayList<String> diceCombinationList(String p, int target) {
        if (target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 1; i <= 6 && i <= target; i++) {
            answer.addAll(diceCombinationList(p + i, target - i));
        }
        return answer;
    }

    // if the die have a custom face count

    public static ArrayList<String> diceFace(String p, int target, int face) {
        if (target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 1; i <= face && i <= target; i++) {
            answer.addAll(diceFace(p + i, target - i, face));
        }
        return answer;
    }
}
