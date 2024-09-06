package recursion;

public class BackTracking {

    public static void main(String[] args) {
        permutation("ABC".toCharArray(), 0);
    }

    private static int[] state = new int[10];
    private static char[] statestr = new char[10];

    public static void permutation(char[] str, int num) {
        if (num == str.length) {
            System.out.println(new String(statestr));
            return;
        }

        for (int i = 0; i < str.length; i++) {
            if (state[i] == 0) {
                statestr[num] = str[i];
                state[i] = 1;
                permutation(str, num + 1);
                state[i] = 0;
            }
        }
    }
}
