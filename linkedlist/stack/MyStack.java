package linkedlist.stack;

public class MyStack<T> {
    private Node<T> top = null;
    private int size = 0;

    private static class Node<NT> {
        public NT data;
        public Node<NT> next;

        Node(NT data) {
            this(data, null);
        }

        Node(NT data, Node<NT> next) {
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");

        Node<T> current = top;
        int count = 0;
        while (current != null) {
            if (count > 0) {
                str.append(", ");
            }
            str.append(current.data);
            current = current.next;
            count++;
        }

        str.append("]");

        str.append(" (").append(count).append(")");
        return str.toString();
    }

    public MyStack<T> push(T value) {
        Node<T> newNode = new Node<T>(value);
        newNode.next = top;
        top = newNode;
        size++;
        return this;
    }

    public T pop() {
        if (size == 0 || top == null) {
            System.out.println("Stack is empty");
            return null;
        }

        Node<T> node = top;
        top = top.next;
        size--;

        return node.data;
    }

    public T peek() {
        if (size == 0 || top == null) {
            System.out.println("Stack is empty");
            return null;
        }

        return top.data;
    }

    public T peek(int pos) {
        if (size == 0 || top == null) {
            System.out.println("Stack is empty");
            return null;
        }

        if (pos < 0 || pos >= size) {
            System.out.println("Index out of bound");
            return null;
        }

        Node<T> current = top;
        int count = pos;

        while (count-- > 0) {
            current = current.next;
        }

        return current.data;
    }

    public boolean isEmpty() {
        return (top == null || size == 0);
    }

    public int size() {
        return size;
    }

    public MyStack<T> clear() {
        top = null;
        size = 0;
        return this;
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1).push(2).push(3);

        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.peek(1));
        System.out.println("Size " + stack.size());
        System.out.println(stack.pop());
    }
}
