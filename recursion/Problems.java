package recursion;

import java.util.*;

class Problems {

    public static void main(String[] args) {

        /*
         * // next combination
         * int ary[] = { 1, 2, 3 };
         * int count = 6;
         * while (count-- != 0) {
         * System.out.println(Arrays.toString(ary));
         * nextPermutation(ary);
         * }
         * 
         * // subset combination
         * System.out.println(substr("", "abc"));
         * 
         * // permutation of strings
         * System.out.println(permutation("", "abc"));
         * 
         * // letter combinartion numberpad
         * System.out.println(getCombinationNumbers("", "19"));
         * 
         * dice("", 4);
         */

        mazeTraversal("", 3, 3, 1, 1, 2, 2);

    }

    public static void nextPermutation(int[] ary) {
        if (ary.length <= 1) {
            return;
        }

        int i = ary.length - 2;
        while (i != -1) {
            if (ary[i] < ary[i + 1]) {
                break;
            }
            i--;
        }

        if (i != -1) {
            int j;
            for (j = ary.length - 1; ary[j] < ary[i]; j--)
                ;

            int temp = ary[i];
            ary[i] = ary[j];
            ary[j] = temp;
        }

        int start = i + 1;
        int end = ary.length - 1;
        while (start < end) {
            int temp = ary[start];
            ary[start] = ary[end];
            ary[end] = temp;

            start++;
            end--;
        }
    }

    public static ArrayList<String> substr(String str, String src) {
        if (src.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(str);
            return list;
        }

        char ch = src.charAt(0);
        ArrayList<String> list1 = substr(ch + str, src.substring(1));
        ArrayList<String> list2 = substr(str, src.substring(1));
        list1.addAll(list2);
        return list1;
    }

    public static ArrayList<String> permutation(String str, String src) {
        if (src.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(str);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < src.length(); i++) {
            String remaining = src.substring(0, i) + src.substring(i + 1);
            ArrayList<String> list2 = permutation(str + src.charAt(i), remaining);
            list.addAll(list2);
        }
        return list;
    }

    public static ArrayList<String> getCombinationNumbers(String str, String src) {

        if (src.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(str);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();
        char ch = src.charAt(0);
        int sublen = (ch == '9' ? 2 : 3);
        int number = ch - '1';
        for (int i = 0; i < sublen; i++) {
            char target = (char) ('a' + number * 3 + i);
            ArrayList<String> solution = getCombinationNumbers(str + target, src.substring(1));
            list.addAll(solution);
        }

        return list;
    }

    public static void dice(String p, int target) {
        if (target == 0) {
            System.out.println(p);
            return;
        }

        for (int i = 1; i <= 6 && i <= target; i++) {
            dice(p + i, target - i);
        }
    }

    public static void mazeTraversal(String solution,
            int currentX, int currentY,
            int targetX, int targetY,
            int obstacleX, int obstacleY) {
        if (currentX == obstacleX && currentY == obstacleY)
            return;
        if (currentX == targetX && currentY == targetY) {
            System.out.println(solution);
            return;
        }

        if (currentX != 0) {
            mazeTraversal(solution + "R ", currentX - 1, currentY, targetX, targetY, obstacleX, obstacleY);
        }

        if (currentX != 0 && currentY != 0) {
            mazeTraversal(solution + "S ", currentX - 1, currentY - 1, targetX, targetY, obstacleX, obstacleY);
        }

        if (currentY != 0) {
            mazeTraversal(solution + "D ", currentX, currentY - 1, targetX, targetY, obstacleX, obstacleY);
        }

    }
}
