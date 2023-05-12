package back_tracking;

public class NKnights {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];

        displayKnights(board, 0, 0, n);

    }


    private static boolean isSafe(boolean[][] board, int row, int col) {
        if (isValid(board, row - 1, col + 2) && board[row - 1][col + 2]) {
            return false;
        }
        if (isValid(board, row + 1, col + 2) && board[row + 1][col + 2]) {
            return false;
        }
        if (isValid(board, row - 1, col - 2) && board[row - 1][col - 2]) {
            return false;
        }
        if (isValid(board, row + 1, col - 2) && board[row + 1][col - 2]) {
            return false;
        }
        if (isValid(board, row - 2, col + 1) && board[row - 2][col + 1]) {
            return false;
        }
        if (isValid(board, row - 2, col - 1) && board[row - 2][col - 1]) {
            return false;
        }
        if (isValid(board, row + 2, col + 1) && board[row + 2][col + 1]) {
            return false;
        }
        return true;
    }

    // a helper function to check if the given row and col is not out of bound
    public static boolean isValid(boolean[][] board, int row, int col) {
        // this condition is for checking inside the matrix
        if (row >= 0 && row < board.length && col >= 0 && col < board.length) {
            return true;
        }
        return false;
    }

    private static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean tile : row) {
                if (tile) {
                    System.out.print("🐴 ");
                } else {
                    System.out.print("⬜ ");
                }

            }
            // new line after each row
            System.out.println();
        }
    }

    // just displaying the N knights without showing the count of the possible answers

    private static void displayKnights(boolean[][] board, int row, int col, int target) {
        // base condition
        if (target == 0) {
            display(board);
            System.out.println();
            return;
        }
        // edge condition for the last block
        // i.e. when the pointer is out of bound,
        // for the last row and at the last + 1 col
        if (row == board.length - 1 && col == board.length) {
            return;
        }

        if (col == board.length) {
            // we have traversed the complete row then we will move to the next row.
            displayKnights(board, row + 1, 0, target);
            return;
        }

        if (isSafe(board, row, col)) {
            board[row][col] = true;
            displayKnights(board, row, col + 1, target - 1);
            // back track
            board[row][col] = false;
        }
        // if above conditions are not satisfied then we will move to the next col
        displayKnights(board, row, col + 1, target);

    }

}
