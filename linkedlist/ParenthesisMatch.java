package linkedlist;

public class ParenthesisMatch {

    private static boolean checkMatching(char[] str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                Character item = stack.pop();
                switch (ch) {
                    case ')':
                        if (item != '(')
                            return false;
                        break;
                    case '}':
                        if (item != '{')
                            return false;
                        break;
                    case ']':
                        if (item != '[')
                            return false;
                        break;
                }

            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        char[] str = "[{(a+b)+{c+b}}]".toCharArray();

        if (checkMatching(str)) {
            System.out.println("Parentheses are valid");
        } else {
            System.out.println("Invalid parentheses");
        }
    }
}
