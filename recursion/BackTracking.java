package recursion;

public class BackTracking {

    public static void main(String[] args) {
        permutation("ABC".toCharArray(), 0);
        System.out.println();
        permutationSwap("ABC".toCharArray(), 0);

    }

    private static final int[] state = new int[10];
    private static final char[] statestr = new char[10];

    public static void permutation(char[] str, int level) {
        if (level == str.length) {
            System.out.println(new String(statestr));
            return;
        }

        for (int i = 0; i < str.length; i++) {
            if (state[i] == 0) {
                statestr[level] = str[i];
                state[i] = 1;
                permutation(str, level + 1);
                state[i] = 0;
            }
        }
    }

    public static void permutationSwap(char[] str, int level) {
        if (level == str.length) {
            System.out.println(new String(str));
            return;
        }

        for (int i = level; i < str.length; i++) {
            swap(str, level, i);
            permutationSwap(str, level + 1);
            swap(str, level, i);
        }
    }

    private static void swap(char[] str, int i1, int i2) {
        char temp = str[i1];
        str[i1] = str[i2];
        str[i2] = temp;
    }
}
