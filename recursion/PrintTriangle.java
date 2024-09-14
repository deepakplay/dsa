package recursion;

public class PrintTriangle {
    public static void main(String[] args) {
        triangle(10, 0);
        triangleTop(0, 0, 10);
    }

    public static void triangle(int row, int col) {
        if (row == 0) {
            return;
        }

        if (row > col) {
            System.out.print(" * ");
            triangle(row, col + 1);
        } else {
            System.out.println();
            triangle(row - 1, 0);
        }
    }

    public static void triangleTop(int row, int col, int n) {
        if (row == n) {
            return;
        }

        if (col <= row) {
            System.out.print(" * ");
            triangleTop(row, col + 1, n);
        } else {
            System.out.println();
            triangleTop(row + 1, 0, n);
        }
    }
}
