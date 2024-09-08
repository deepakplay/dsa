package linkedlist.stack;

public class EvalPostFix {

    public static Double eval(String exp) {
        String postFix = InfixToPostfix.postfix(exp);
        MyStack<Double> expStack = new MyStack<>();

        for (int i = 0; i < postFix.length(); i++) {
            Character ch = postFix.charAt(i);
            if (Character.isDigit(ch)) {
                expStack.push((double) (ch - '0'));
            } else {
                Double op2 = expStack.pop();
                Double op1 = expStack.pop();
                switch (ch) {
                    case '+':
                        expStack.push(op1 + op2);
                        break;
                    case '-':
                        expStack.push(op1 - op2);
                        break;
                    case '*':
                        expStack.push(op1 * op2);
                        break;
                    case '/':
                        expStack.push(op1 / op2);
                        break;
                    case '^':
                        expStack.push(Math.pow(op1, op2));
                        break;
                    default:
                        break;
                }
            }
        }
        System.out.println(postFix);
        return expStack.pop();
    }

    public static void main(String[] args) {
        String expression = "5+8^2^3+9*9";
        System.out.println(eval(expression));
        System.out.println(5 + Math.pow(8, Math.pow(2, 3)) + 9 * 9);
    }
}
