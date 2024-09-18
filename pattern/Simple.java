package pattern;

public class Simple {
    public static void main(String[] args) {
        int num = 5;

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();
        /////////////////////////////////////

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                System.out.printf("%-2d ", i);
            }
            System.out.println();
        }

        System.out.println();
        /////////////////////////////////////

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();
        /////////////////////////////////////

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        System.out.println();
        /////////////////////////////////////

        for (int i = 1; i <= num; i++) {
            int colStart = i % 2 == 0 ? 0 : 1;
            for (int j = 1; j <= i; j++) {
                System.out.print(colStart + " ");
                if (colStart == 1)
                    colStart = 0;
                else
                    colStart = 1;
            }
            System.out.println();
        }

        System.out.println();
        /////////////////////////////////////

        int count = 1;
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%-3d", count++);
            }
            System.out.println();
        }

        System.out.println();
        /////////////////////////////////////

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num - i + 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println();
        /////////////////////////////////////

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num - i + 1; j++) {
                System.out.printf("%-3d", (num - i + 1));
            }
            System.out.println();
        }

        System.out.println();
        /////////////////////////////////////

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num - i + 1; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        System.out.println();
        /////////////////////////////////////

        for (int i = 1; i <= num * 2 - 1; i++) {

            int row = i <= num ? i : num * 2 - i;

            for (int j = 1; j <= row; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();
        /////////////////////////////////////

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j < num - i + 1; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();
        /////////////////////////////////////

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= num - i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();
        /////////////////////////////////////

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num - i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i * 2 - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();
        /////////////////////////////////////

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= num * 2 - (i * 2 - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();
        /////////////////////////////////////

        for (int i = 1, k = 0; i <= num * 2 - 1; i++) {
            k = i <= num ? i : num * 2 - i;

            for (int j = 1; j <= num - k; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= k * 2 - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();
        /////////////////////////////////////

        for (int i = 1; i <= num * 2 - 1; i++) {
            int k = i <= num ? i : num * 2 - i;

            for (int j = 1; j < k; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= num - k + 1; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }

        System.out.println();
        /////////////////////////////////////

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num - i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= (i * 2 - 1); j++) {
                if (j == 1 || j == (i * 2 - 1) || i == num) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }

        System.out.println();
        /////////////////////////////////////

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= (num * 2 - (i * 2 - 1)); j++) {
                if (i == 1 || j == 1 || j == (num * 2 - (i * 2 - 1))) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }

        System.out.println();
        /////////////////////////////////////

        for (int i = 1; i <= num * 2 - 1; i++) {
            int k = i <= num ? i : num * 2 - i;

            for (int j = 1; j <= num - k; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= k * 2 - 1; j++) {
                if (j == 1 || j == k * 2 - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        System.out.println();
        /////////////////////////////////////

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num - 1; j++) {
                if (i == 1 || j == 1 || i == num || j == num - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        System.out.println();
        /////////////////////////////////////

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= num - 1; j++) {
                if (i == 1 || j == 1 || i == num || j == num - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        System.out.println();
        /////////////////////////////////////

        for (int i = 1; i <= num * 2; i++) {
            int k = (i <= num) ? i : (num * 2 - i) + 1;
            int start = num - k + 1;
            int end = num + k;

            for (int j = 1; j <= num * 2; j++) {

                if (j > start && j < end) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }

        System.out.println();
        /////////////////////////////////////

        for (int i = 1; i <= num * 2 - 1; i++) {
            int k = i <= num ? i : num * 2 - i;

            int start = k;
            int end = num * 2 - k + 1;

            for (int j = 1; j <= num * 2; j++) {

                if (j > start && j < end) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }

            System.out.println();
        }

        System.out.println();
        /////////////////////////////////////

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num - i; j++) {
                System.out.print(" ");
            }

            for (int j = i; j > 0; j--) {
                System.out.print(j);
            }

            for (int j = 2; j <= i; j++) {
                System.out.print(j);
            }

            System.out.println();
        }

        System.out.println();
        /////////////////////////////////////

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            for (int j = 1; j <= (num - i) * 2; j++) {
                System.out.print(" ");
            }
            for (int j = i; j > 0; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
