package pattern;

// https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/
public class TUFPatterns {
    public static void main(String[] args) {
        pattern1(5);
        pattern2(5);
        pattern3(5);
        pattern4(5);
        pattern5(5);
        pattern6(5);
        pattern7(5);
        pattern8(5);
        pattern9(5);
        pattern10(5);
        pattern11(5);
        pattern12(5);
        pattern13(5);
        pattern14(5);
        pattern15(5);
        pattern16(5);
        pattern17(5);
        pattern18(5);
        pattern19(5);
        pattern20(5);
        pattern21(5);
        pattern22(5);
    }

    public static void pattern1(int n) {
        System.out.println("1:");

        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= n; x++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern2(int n) {
        System.out.println("2:");

        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= y; x++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern3(int n) {
        System.out.println("3:");

        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= y; x++) {
                System.out.print(x);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern4(int n) {
        System.out.println("4:");

        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= y; x++) {
                System.out.print(y);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern5(int n) {
        System.out.println("5:");
        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= n - y + 1; x++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern6(int n) {
        System.out.println("6:");
        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= n - y + 1; x++) {
                System.out.print(x);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern7(int n) {
        System.out.println("7:");

        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= n - y; x++) {
                System.out.print(" ");
            }

            for (int x = 1; x <= y * 2 - 1; x++) {
                System.out.print("*");
            }

            System.out.println();
        }
        System.out.println();
    }

    public static void pattern8(int n) {
        System.out.println("8:");
        for (int y = 1; y <= n; y++) {
            for (int x = 1; x < y; x++) {
                System.out.print(" ");
            }

            for (int x = 1; x <= (n - y) * 2 + 1; x++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern9(int n) {
        System.out.println("9:");
        for (int y = 1; y <= n * 2; y++) {
            int k = y <= n ? y : n * 2 - y + 1;

            for (int x = 1; x <= n - k; x++) {
                System.out.print(" ");
            }

            for (int x = 1; x <= k * 2 - 1; x++) {
                System.out.print("*");
            }

            System.out.println();
        }
        System.out.println();
    }

    public static void pattern10(int n) {
        System.out.println("10:");

        for (int y = 1; y < n * 2; y++) {
            int k = y <= n ? y : n * 2 - y;

            for (int x = 1; x <= k; x++) {
                System.out.print("*");
            }

            System.out.println();
        }
        System.out.println();
    }

    public static void pattern11(int n) {
        System.out.println("11:");

        for (int y = 1; y <= n; y++) {
            int num = y & 1;

            for (int x = 1; x <= y; x++) {
                System.out.print(num + " ");
                num = num == 0 ? 1 : 0;
            }

            System.out.println();
        }
        System.out.println();
    }

    public static void pattern12(int n) {
        System.out.println("12:");

        for (int y = 1; y <= n; y++) {
            for (int x = 1; x < y; x++)
                System.out.print(x);

            for (int x = 1; x <= (n - y) * 2; x++) {
                System.out.print(" ");
            }

            for (int x = y - 1; x > 0; x--) {
                System.out.print(x);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern13(int n) {
        System.out.println("13:");
        int count = 1;
        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= y; x++) {
                System.out.print(count++ + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern14(int n) {
        System.out.println("14:");

        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= y; x++) {
                char ch = (char) ('A' + (x - 1) % 26);
                System.out.print(ch);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern15(int n) {
        System.out.println("15:");

        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= n - y + 1; x++) {
                char ch = (char) ('A' + (x - 1) % 26);
                System.out.print(ch);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern16(int n) {
        System.out.println("16:");

        for (int y = 1; y <= n; y++) {
            char ch = (char) ('A' + (y - 1) % 26);

            for (int x = 1; x <= y; x++) {
                System.out.print(ch);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern17(int n) {
        System.out.println("17:");

        for (int y = 1; y < n; y++) {
            for (int x = 1; x <= n - y; x++) {
                System.out.print(" ");
            }

            for (int x = 1; x <= (y * 2) - 1; x++) {
                int k = x <= y ? x : y * 2 - x;
                char ch = (char) ('A' + (k - 1) % 26);
                System.out.print(ch);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern18(int n) {
        System.out.println("18:");

        for (int y = n; y > 0; y--) {
            int num = y;
            for (int x = 1; x <= (n - y) + 1; x++) {
                char ch = (char) ('A' + (num - 1) % 26);
                System.out.print(ch + " ");
                num++;
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern19(int n) {
        System.out.println("19:");

        for (int y = 1; y <= n * 2; y++) {
            for (int x = 1; x <= n * 2; x++) {
                int k = y <= n ? y : n * 2 - y + 1;

                int start = n - k + 1;
                int end = n * 2 - start + 1;
                if (x > start && x < end) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern20(int n) {
        System.out.println("20:");

        for (int y = 1; y < n * 2; y++) {
            for (int x = 1; x <= n * 2; x++) {
                int k = y <= n ? y : n * 2 - y;

                int start = k;
                int end = n * 2 - start + 1;

                if (x > start && x < end) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern21(int n) {
        System.out.println("21:");
        for (int y = 1; y < n; y++) {
            for (int x = 1; x < n; x++) {
                if (x == 1 || x == n - 1 || y == 1 || y == n - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern22(int n) {
        System.out.println("22:");
        for (int y = 1; y < n * 2; y++) {
            for (int x = 1; x < n * 2; x++) {
                int min = y;
                if (min > x) {
                    min = x;
                }
                if (min > n * 2 - x) {
                    min = n * 2 - x;
                }
                if (min > n * 2 - y) {
                    min = n * 2 - y;
                }
                System.out.print(n - min + 1);
            }
            System.out.println();
        }
    }
}