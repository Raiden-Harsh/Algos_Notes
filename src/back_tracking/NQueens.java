package back_tracking;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        int ans = queens(board, 0);
        System.out.println(" total number of possible ways : " + ans);

    }

    // we are not passing the col as it is starting from zero each time.
    public static int queens(boolean[][] board, int row) {
        // base condition
        if (board.length == row) {
            display(board);
            System.out.println();
            // one of the potential answer found!
            return 1;
        }
        int count = 0;

        // placing the queen and checking for each row and column
        for (int col = 0; col < board.length; col++) {
            // place the queen if safe to do so
            if (isSafe(board, row, col)) {
                // queen placed
                board[row][col] = true;
                count += queens(board, row + 1);
                // this is back tracking
                // we are reverting the changes we have made in the previous recursion calls
                board[row][col] = false;
            }
        }

        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        // check vertical row
        for (int i = 0; i <= row; i++) {
            if (board[i][col]) {
                // there is a queen already there
                return false;
            }
        }

        // left diagonal

        int maxLeft = Math.min(row, col);

        for (int i = 1; i <= maxLeft; i++) {
            // queen already at left diagonal
            if (board[row - i][col - i]) {
                return false;
            }
        }

        // right diagonal

        int maxRight = Math.min(row, (board.length) - col - 1);

        for (int i = 1; i <= maxRight; i++) {
            // queen already at right diagonal
            if (board[row - i][col + i]) {
                return false;
            }
        }
        return true;
    }

    private static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                // true is Queen
                if (element) {
                    System.out.print("👑 ");
                } else {
                    System.out.print("⬜ ");
                }
            }
            // new line after each row
            System.out.println();
        }
    }
}
