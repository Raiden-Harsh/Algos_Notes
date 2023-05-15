package back_tracking;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] board = {
                { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
                { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
                { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
                { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
                { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
                { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
                { 0, 9, 0, 0, 0, 0, 4, 0, 0 }
        };
        System.out.println(solve(board));

    }

    private static boolean solve(int[][] board) {
        int n = board.length;
        int row = -1;
        int col = -1;

        boolean emptyLeft = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // check for an empty place
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }
            if (!emptyLeft) {
                break;
            }
        }

        if (emptyLeft) {
            // sudoku is solved!
            return true;
        }

        // backtrack
        for (int number = 1; number <= 9; number++) {
            if (isSafe(board, row, col, number)) {
                board[row][col] = number;
                if (solve(board)) {
                    // found the answer
                    display(board);
                    System.out.println("-------------------------");
                    return true;
                } else {
                    // backtrack
                    board[row][col] = 0;
                }
            }

        }
        // finally if nothing is true, i.e. the sudoku can't be solved!
        return false;
    }

    private static void display(int[][] board) {
        for (int[] row : board) {
            for (int n : row) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    private static boolean isSafe(int[][] board, int row, int col, int num) {
        // check for the row
        for (int i = 0; i < board.length; i++) {
            // check if number is in the row
            if (num == board[i][col]) {
                return false;
            }
        }
        // check for column
        for (int i = 0; i < board.length; i++) {
            // check if the number is in the col
            if (board[row][i] == num) {
                return false;
            }
        }
        // to check for the small boxes

        int sqrt = (int) (Math.sqrt(board.length));
        // to calculate the coordinate of the square
        int rowstart = row - row % sqrt;
        int colStart = col - col % sqrt;

        for (int r = rowstart; r < (rowstart + sqrt); r++) {
            for (int c = colStart; c < (colStart + sqrt); c++) {
                if (num == board[r][c]) {
                    return false;
                }
            }

        }
        return true;
    }
}
