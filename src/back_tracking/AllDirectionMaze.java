package back_tracking;

import java.util.Arrays;

public class AllDirectionMaze {
    public static void main(String[] args) {
        boolean[][] maze = {{true, true, true}, {true, true, true}, {true, true, true}};
        allPath("", maze, 0, 0);
        int[][] path = new int[maze.length][maze[0].length];
        allPathPrint("",maze,0,0,path,1);

    }

    public static void allPath(String p, boolean[][] maze, int r, int c) {
        // base condition
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }
        // maze is a boolean array with obstacles as false
        if (!maze[r][c]) {
            return;
        }
        // I am considering this block
        maze[r][c] = false;

        if (c > 0) {
            allPath(p + "L", maze, r, c - 1);
        }
        if (r > 0) {
            allPath(p + "U", maze, r - 1, c);
        }
        if (r < maze.length - 1) {
            allPath(p + "D", maze, r + 1, c);
        }
        if (c < maze[0].length - 1) {
            allPath(p + "R", maze, r, c + 1);
        }

        // this is where this method will end,
        // and will be removed from the stack memory
        // before removal we will undo the changes done by it
        // this is called as back tracking
        maze[r][c] = true;
    }

    // to print the complete path

    public static void allPathPrint(String p, boolean[][] maze, int r, int c, int[][] path, int step) {
        // base condition
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            // to get the final element also
            path[r][c] = step;
            for(int[] arr : path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println("--------------------");
            path[r][c] = 0;
            return;
        }
        // maze is a boolean array with obstacles as false
        if (!maze[r][c]) {
            return;
        }
        // I am considering this block
        maze[r][c] = false;
        path[r][c] = step;

        if (c > 0) {
            allPathPrint(p + "L", maze, r, c - 1, path, step + 1);
        }
        if (r > 0) {
            allPathPrint(p + "U", maze, r - 1, c, path, step + 1);
        }
        if (r < maze.length - 1) {
            allPathPrint(p + "D", maze, r + 1, c, path, step + 1);
        }
        if (c < maze[0].length - 1) {
            allPathPrint(p + "R", maze, r, c + 1, path, step + 1);
        }

        // this is where this method will end,
        // and will be removed from the stack memory
        // before removal we will undo the changes done by it
        // this is called as back tracking
        maze[r][c] = true;
        path[r][c] = 0;
    }

}
