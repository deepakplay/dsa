package sort;

import java.util.Arrays;

public class Sort {
    private static void swap(int ary[], int i, int j) {
        if (i == j || i >= ary.length || j >= ary.length) {
            return;
        }
        int temp = ary[i];
        ary[i] = ary[j];
        ary[j] = temp;
    }

    private static void print(int ary[]) {
        System.out.println(Arrays.toString(ary));
    }

    public static int[] copy(int[] ary) {
        return Arrays.copyOf(ary, ary.length);
    }

    public static int[] bubbleSort(int[] ary) {

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

    public static int[] selectionSort(int[] ary) {

        for (int i = 0; i < ary.length; i++) {
            int min = i;
            for (int j = i + 1; j < ary.length; j++) {
                if (ary[min] > ary[j]) {
                    min = j;
                }
            }

            if (i != min) {
                swap(ary, i, min);
            }
        }

        return ary;
    }

    private static int partition(int[] ary, int start, int end) {
        int idx = start;

        for (int i = start; i < end; i++) {
            if (ary[i] < ary[end]) {
                if (start != i) {
                    swap(ary, idx, i);
                }
                idx++;
            }
        }
        swap(ary, end, idx);
        return idx;
    }

    private static void quickSort(int[] ary, int start, int end) {
        if (start >= end)
            return;

        int pivot = partition(ary, start, end);
        quickSort(ary, start, pivot - 1);
        quickSort(ary, pivot + 1, end);
    }

    public static int[] quickSort(int[] ary) {
        quickSort(ary, 0, ary.length - 1);
        return ary;
    }

    private static int[] mergeSort(int[] ary, int start, int end) {
        if (start == end) {
            int[] newAry = new int[1];
            newAry[0] = ary[start];
            return newAry;
        }

        int mid = start + ((end - start) / 2);
        int[] ary1 = mergeSort(ary, start, mid);
        int[] ary2 = mergeSort(ary, mid + 1, end);

        int[] newAry = new int[ary1.length + ary2.length];
        int i = 0, j = 0, idx = 0;

        while (i < ary1.length && j < ary2.length) {
            if (ary1[i] <= ary2[j]) {
                newAry[idx++] = ary1[i++];
            } else {
                newAry[idx++] = ary2[j++];
            }
        }

        while (i < ary1.length) {
            newAry[idx++] = ary1[i++];
        }

        while (j < ary2.length) {
            newAry[idx++] = ary2[j++];
        }

        return newAry;
    }

    public static int[] mergeSort(int[] ary) {
        return mergeSort(ary, 0, ary.length - 1);
    }

    // in-place merge sort
    private static void mergeSortIP(int[] ary, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + ((end - start) / 2);
        mergeSortIP(ary, start, mid);
        mergeSortIP(ary, mid + 1, end);

        int start1 = start;
        int end1 = mid;

        int start2 = mid + 1;
        int end2 = end;

        while (start1 <= end1 && start2 <= end2) {
            if (ary[start1] <= ary[start2]) {
                start1++;
            } else {
                int val = ary[start2];
                int i = start2;

                while (i > start1) {
                    ary[i] = ary[i - 1];
                    i--;
                }

                ary[i] = val;
                start1++;
                end1++;
                start2++;
            }
        }

        return;
    }

    public static int[] mergeSortIP(int[] ary) {
        mergeSortIP(ary, 0, ary.length - 1);
        return ary;
    }

    public static void main(String[] args) {
        int ary[] = { 15, 5, 34, 65, 1, 47, 5, 548, 6, 84, 91, 22, 24, 24, 89 };

        print(bubbleSort(copy(ary)));
        print(insertionSort(copy(ary)));
        print(selectionSort(copy(ary)));
        print(quickSort(copy(ary)));
        print(mergeSort(copy(ary)));
        print(mergeSortIP(copy(ary)));
    }
}
