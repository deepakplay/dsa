package recursion.backtrack;

public class SudokuSolver {

    public static void main(String[] args) {
        int[][] board = {
                { 0, 4, 5, 0, 0, 0, 9, 0, 0 },
                { 0, 0, 0, 1, 9, 0, 0, 0, 5 },
                { 6, 0, 0, 0, 0, 3, 0, 0, 8 },

                { 0, 0, 4, 9, 0, 2, 0, 8, 0 },
                { 0, 7, 0, 0, 3, 0, 0, 1, 0 },
                { 0, 3, 0, 8, 0, 4, 5, 0, 0 },

                { 4, 0, 0, 7, 0, 0, 0, 0, 9 },
                { 7, 0, 0, 0, 4, 6, 0, 0, 0 },
                { 0, 0, 1, 0, 0, 0, 7, 6, 0 },
        };

        display(board);
        solve(board, 0, 0);
    }

    public static boolean solve(int[][] board, int row, int col) {
        if (row == 9) {
            display(board);
            return true;
        }

        if (col == 9) {
            return solve(board, row + 1, 0);
        }

        if (board[row][col] != 0) {
            return solve(board, row, col + 1);
        }

        for (int num = 1; num <= 9; num++) {
            if (isValid(board, row, col, num)) {
                board[row][col] = num;
                if (solve(board, row, col + 1)) {
                    return true;
                }
                board[row][col] = 0;
            }
        }

        return false;
    }

    public static void display(int[][] board) {
        for (int[] row : board) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    public static boolean isValid(int[][] board, int row, int col, int val) {
        for (int i = 0; i < 9; i++) {
            // row check
            if (board[i][col] == val) {
                return false;
            }

            // col check
            if (board[row][i] == val) {
                return false;
            }
        }

        // block check
        int rowStart = (row / 3) * 3;
        int rowEnd = rowStart + 3;

        int colStart = (col / 3) * 3;
        int colEnd = colStart + 3;

        for (int i = rowStart; i < rowEnd; i++) {
            for (int j = colStart; j < colEnd; j++) {
                if (board[i][j] == val) {
                    return false;
                }
            }
        }

        return true;
    }
}

// empty board
// { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
// { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
// { 0, 0, 0, 0, 0, 0, 0, 0, 0 },

// { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
// { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
// { 0, 0, 0, 0, 0, 0, 0, 0, 0 },

// { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
// { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
// { 0, 0, 0, 0, 0, 0, 0, 0, 0 },