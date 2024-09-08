package linkedlist.stack;

public class InfixToPostfix {

    private static int precedence(Character ch) {
        switch (ch) {
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
        }
        return -1;
    }

    private static boolean isLeftAssociative(Character ch) {
        if (ch.equals('^')) {
            return false;
        }
        return true;
    }

    public static String postfix(String exp) {

        MyStack<Character> stack = new MyStack<>();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < exp.length(); i++) {
            Character ch = exp.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                output.append(ch);
            } else if (ch.equals('(')) {
                stack.push(ch);
            } else if (ch.equals(')')) {
                while (!stack.isEmpty() && !(stack.peek().equals('('))) {
                    output.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && (
                        (isLeftAssociative(ch) && precedence(stack.peek()) >= precedence(ch)) ||
                        (!isLeftAssociative(ch) && precedence(stack.peek()) > precedence(ch)))) {
                    output.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            output.append(stack.pop());
        }

        return output.toString();
    }

    public static void main(String[] args) {
        String exp = "K+L-M*N+(O^P)*W/U/V*T+Q";

        String postfix = postfix(exp);
        System.out.println(postfix);
    }
}
