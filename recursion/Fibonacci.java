package recursion;

public class Fibonacci {
    public static void main(String[] args) {
        for (int i = 0; i <= 20; i++) {
            System.out.print(fibR(i) + " ");
        }

        System.out.println();

        for (int i = 0; i <= 20; i++) {
            System.out.print(fibI(i) + " ");
        }
    }

    static int[] fibRMap = new int[1000];

    private static int fibR(int n) {
        if (n <= 1) {
            fibRMap[n] = n;
            return n;
        }

        if (fibRMap[n] == 0) {
            fibRMap[n] = fibR(n - 2) + fibR(n - 1);
        }

        return fibRMap[n];
    }

    private static int fibI(int n) {
        if (n <= 1) {
            return n;
        }

        int a = 0;
        int b = 1;

        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }

        return b;
    }

}