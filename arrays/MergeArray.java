package arrays;

public class MergeArray {
    public static void main(String[] args) {
        int[] array1 = new int[] { 5, 7, 9, 23, 28, 31, 34, 39 };
        int[] array2 = new int[] { 2, 3, 4, 5, 9, 12, 15, 18, 23, 35 };

        int[] array3 = mergeArray(array1, array2);

        for (int num : array3) {
            System.out.print(num + " ");
        }
    }

    private static int[] mergeArray(int[] a1, int[] a2) {
        int[] newArray = new int[a1.length + a2.length];
        int i = 0, j = 0, idx = 0;

        while (i < a1.length && j < a2.length) {
            if (a1[i] <= a2[j]) {
                newArray[idx++] = a1[i++];
            } else {
                newArray[idx++] = a2[j++];
            }
        }

        while (i < a1.length) {
            newArray[idx++] = a1[i++];
        }

        while (j < a2.length) {
            newArray[idx++] = a2[j++];
        }

        return newArray;
    }
}
