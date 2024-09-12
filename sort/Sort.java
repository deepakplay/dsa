package sort;

import java.util.Arrays;

public class Sort {
    private static void swap(int ary[], int i, int j) {
        int temp = ary[i];
        ary[i] = ary[j];
        ary[j] = temp;
    }

    private static void print(int ary[]) {
        for (int i : ary) {
            System.err.print(i + " ");
        }
        System.err.println();
    }

    public static int[] bubbleSort(int[] ary) {

        ary = Arrays.copyOf(ary, ary.length);

        for (int i = 0; i < ary.length; i++) {
            boolean swap = false;
            for (int j = 1; j < ary.length - i; j++) {
                if (ary[j - 1] > ary[j]) {
                    swap(ary, j, j - 1);
                    swap = true;
                }
            }

            if (!swap) {
                break;
            }
        }

        return ary;
    }

    public static int[] insertionSort(int[] ary) {
        ary = Arrays.copyOf(ary, ary.length);

        for (int i = 1; i < ary.length; i++) {
            int key = ary[i];
            int j = i - 1;
            while (j >= 0 && ary[j] > key) {
                ary[j + 1] = ary[j];
                j--;
            }
            ary[j + 1] = key;
        }

        return ary;
    }

    public static void main(String[] args) {
        int ary[] = { 5, 84, 91, 5, 1, 47, 5, 548, 6, 24, 24, 89, 22, 15, 34 };

        print(bubbleSort(ary));
        print(insertionSort(ary));
    }
}
