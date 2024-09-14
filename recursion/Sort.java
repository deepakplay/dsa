package recursion;

import java.util.Arrays;

public class Sort {

    public static void swap(int[] ary, int i, int j) {
        int temp = ary[i];
        ary[i] = ary[j];
        ary[j] = temp;
    }

    public static int[] bubbleSort(int[] ary, int idx, int len) {
        if (len == 0) {
            return ary;
        }

        if (idx < len) {
            if (ary[idx] > ary[idx + 1])
                swap(ary, idx, idx + 1);

            return bubbleSort(ary, idx + 1, len);
        } else {
            return bubbleSort(ary, 0, len - 1);
        }
    }

    public static void main(String[] args) {
        int[] ary = { 74, 4, 25, 59, 11, 5, 8, 14, 17 };

        int[] newAry = bubbleSort(Arrays.copyOf(ary, ary.length), 0, ary.length - 1);
        System.out.println(Arrays.toString(newAry));
    }
}
