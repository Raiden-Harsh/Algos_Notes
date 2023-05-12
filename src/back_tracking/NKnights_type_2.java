package back_tracking;

// we will try to solve the N-Knights problem without passing the col
// just like N - Queen 👑
// we will display the count as well
// this is more manageable than having multiple variables in the recursion calls!
public class NKnights_type_2 {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        int ans = knights(board, 0);
        System.out.println("possible ways : " + ans);
    }

    private static int knights(boolean[][] board, int row) {
        // base condition
        if (row == board.length) {
            display(board);
            System.out.println();
            return 1;
        }
        // this will count the total number of possible ways
        int count = 0;

        // we will check for each col
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                // place the knight
                board[row][col] = true;
                count += knights(board, row + 1);
                // back track
                board[row][col] = false;
            }

        }

        return count;

    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        // RRU
        if (isValid(board, row - 1, col + 2) && board[row - 1][col + 2]) {
            return false;
        }
        //RRD
        if (isValid(board, row + 1, col + 2) && board[row + 1][col + 2]) {
            return false;
        }
        // LLU
        if (isValid(board, row - 1, col - 2) && board[row - 1][col - 2]) {
            return false;
        }
        // LLD
        if (isValid(board, row + 1, col - 2) && board[row + 1][col - 2]) {
            return false;
        }
        // UUR
        if (isValid(board, row - 2, col + 1) && board[row - 2][col + 1]) {
            return false;
        }
        // UUL
        if (isValid(board, row - 2, col - 1) && board[row - 2][col - 1]) {
            return false;
        }
        // DDR
        if (isValid(board, row + 2, col + 1) && board[row + 2][col + 1]) {
            return false;
        }
        // DDL
        if (isValid(board, row + 2, col - 1) && board[row + 2][col - 1]) {
            return false;
        }

        return true;
    }

    // row and col are inside the board !
    private static boolean isValid(boolean[][] board, int row, int col) {
        if (row >= 0 && row < board.length && col >= 0 && col < board.length) {
            return true;
        }
        return false;
    }

    // a helper function to display the board
    private static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean tile : row) {
                if (tile) {
                    System.out.print("🐴");
                } else {
                    System.out.print("◼️");
                }
            }
            System.out.println();
        }
    }
}
