package recursion;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorialR(5));
        System.out.println(factorialI(5));
    }

    private static int factorialR(int num) {
        if (num <= 1)
            return 1;
        return factorialR(num - 1) * num;
    }

    private static int factorialI(int num) {
        int fact = 1;

        for (int i = num; i >= 1; i--)
            fact *= i;
        return fact;
    }
}
