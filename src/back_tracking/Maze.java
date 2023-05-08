package back_tracking;

import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {
        System.out.println(count(3, 3));
        path("", 3, 3);
        System.out.println(pathArray("", 3, 3));
        System.out.println(pathArrDiagonal("",3,3));
        boolean[][] maze = {
                {true,true,true},
                {true,false,true},
                {true,true,true}
        };
        pathRestriction("",maze,0,0);

    }

    public static int count(int r, int c) {
        // base condition
        if (r == 1 || c == 1) {
            return 1;
        }
        int left = count(r - 1, c);
        int right = count(r, c - 1);
        return left + right;
    }

    // print the complete path of the maze

    public static void path(String p, int r, int c) {
        // base condition
        if (r == 1 && c == 1) {
            System.out.println(p);
            return;
        }
        if (r > 1) {
            path(p + "D", r - 1, c);
        }
        if (c > 1) {
            path(p + "R", r, c - 1);
        }
    }

    // to print the arraylist
    public static ArrayList<String> pathArray(String p, int r, int c) {
        // base condition
        if (r == 1 && c == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        // answer arraylist which will contain all the answers from each level
        ArrayList<String> ans = new ArrayList<>();

        if (r > 1) {
            ans.addAll(pathArray(p + "D", r - 1, c));
        }
        if (c > 1) {
            ans.addAll(pathArray(p + "R", r, c - 1));
        }
        return ans;
    }

    // if we are going diagonal as well
    public static ArrayList<String> pathArrDiagonal(String p, int r, int c) {
        // base condition
        if (r == 1 && c == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        // answer arraylist which will contain all the answers from each level
        ArrayList<String> ans = new ArrayList<>();
        // here D is diagonal, H is horizontal, V is vertical
        if(r>1 && c>1){
            ans.addAll(pathArrDiagonal(p + "D", r - 1, c - 1));
        }
        if (r > 1) {
            ans.addAll(pathArrDiagonal(p + "H", r - 1, c));
        }
        if (c > 1) {
            ans.addAll(pathArrDiagonal(p + "V", r, c - 1));
        }
        return ans;
    }

    // if we have a restriction in the maze, i.e. we cant go to some specific cells
    public static void pathRestriction(String p, boolean[][] maze, int r, int c) {
        // base condition
        if (r == maze.length -1 && c == maze[0].length -1 ) {
            System.out.println(p);
            return;
        }
        // maze is a boolean array with obstacles as false
        if (!maze[r][c]) {
            return;
        }

        if (r < maze.length -1) {
            pathRestriction(p + "D", maze,r + 1, c);
        }
        if (c < maze[0].length -1) {
            pathRestriction(p + "R",maze, r, c +1);
        }
    }

}
