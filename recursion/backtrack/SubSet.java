package recursion.backtrack;

public class SubSet {
    public static void main(String[] args) {
        String arr = "abcd";
        StringBuilder str = new StringBuilder();
        
        subset(arr, str, 0);
    }

    public static void subset(String arr, StringBuilder str, int idx) {
        if (arr.length() <= idx) {
            if (!str.isEmpty()) {
                System.out.println(str.toString());
            }
            return;
        }

        str.append(arr.charAt(idx));
        subset(arr, str, idx + 1);
        str.deleteCharAt(str.length() - 1);
        subset(arr, str, idx + 1);
    }
}
