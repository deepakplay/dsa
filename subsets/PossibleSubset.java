package subsets;

import java.util.*;

class Possible {

    public static void main(String[] args) {

        System.out.println(substr("", "aabc"));
        System.out.println(substrItr("aabc"));
    }

    public static HashSet<String> substr(String str, String src) {
        if (src.isEmpty()) {
            HashSet<String> list = new HashSet<>();
            if (str.isEmpty()) {
                list.add("[]");
            } else {
                list.add(str);
            }
            return list;
        }

        char ch = src.charAt(0);
        HashSet<String> list1 = substr(ch + str, src.substring(1));
        HashSet<String> list2 = substr(str, src.substring(1));
        list1.addAll(list2);
        return list1;
    }

    public static List<List<Character>> substrItr(String str) {
        List<List<Character>> list = new ArrayList<>();

        list.add(new ArrayList<>());

        int start = 0;
        int end = 0;

        for (int i = 0; i < str.length(); i++) {

            if (i > 0 && str.charAt(i) == str.charAt(i - 1)) {
                start = end + 1;
            } else {
                start = 0;
            }
            end = list.size() - 1;

            for (int j = start; j <= end; j++) {
                List<Character> newList = new ArrayList<>(list.get(j));
                newList.add(str.charAt(i));
                list.add(newList);
            }
        }

        return list;
    }
}
