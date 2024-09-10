package linkedlist.stack;

public class EvalPostFix {

    public static Double eval(String exp) {
        String postFix = InfixToPostfix.postfix(exp);
        System.out.println("Postfix: " + postFix);

        MyStack<Double> expStack = new MyStack<>();

        for (int i = 0; i < postFix.length(); i++) {
            char ch = postFix.charAt(i);
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

        return expStack.pop();
    }

    public static void main(String[] args) {
        String expression = "(5/6+8^2-(3+9)/7*9)^3";
        System.out.println("Infix: " + expression);

        System.out.println("Result: " + eval(expression));
        System.out.println("Proof: " + Math.pow(5.0 / 6.0 + Math.pow(8, 2) - (3.0 + 9.0) / 7.0 * 9, 3));
    }
}
