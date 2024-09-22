package recursion.backtrack;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        int[][] board = new int[n][n];

        System.out.println("Number of ways : " + queens(board, 0));
    }

    public static int queens(int[][] queens, int row) {
        if (row == queens.length) {
            displayBoard(queens);
            return 1;
        }

        int count = 0;
        for (int col = 0; col < queens[0].length; col++) {
            if (isValid(queens, row, col)) {
                queens[row][col] = 1;
                count += queens(queens, row + 1);
                queens[row][col] = 0;
            }
        }
        return count;
    }

    public static boolean isValid(int[][] queens, int row, int col) {
        for (int r = row - 1; r >= 0; r--) {
            if (queens[r][col] == 1) {
                return false;
            }
        }

        for (int r = row - 1, c = col + 1; r >= 0 && c < queens[0].length; r--, c++) {
            if (queens[r][c] == 1) {
                return false;
            }
        }

        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            if (queens[r][c] == 1) {
                return false;
            }
        }

        return true;
    }

    public static void displayBoard(int[][] queens) {
        for (int[] row : queens) {
            for (int col : row) {
                System.out.print(col == 1 ? "Q " : "x ");
            }
            System.out.println();
        }

        System.out.println();
    }

}
