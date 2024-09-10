package recursion;

public class Power {
    public static void main(String[] args) {
        System.out.println(powerR(1000, 3));
        System.out.println(powerI(1000, 3));
        System.out.println(powerRO(1000, 3));
    }

    private static int powerR(int num, int power) {
        if (power <= 0) return 1;

        return powerR(num, power - 1) * num;
    }

    private static int powerI(int num, int power) {
        int result = 1;
        for (int i = 0; i < power; i++) {
            result *= num;
        }
        return result;
    }

    // optimized version
    private static int powerRO(int num, int power) {
        if (power == 0) {
            return 1;
        }

        if (power % 2 == 0) {
            return powerRO(num * num, power / 2);
        }

        return num * powerRO(num * num, (power - 1) / 2);
    }
}
