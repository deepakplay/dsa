package linkedlist.queue;

public class MyQueue<T> {
    private class Node<NT> {
        NT data;
        Node<NT> next;

        Node(NT data) {
            this(data, null);
        }

        Node(NT data, Node<NT> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<T> front = null;
    private Node<T> rear = null;
    private int length = 0;

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        int count = 0;
        Node<T> current = front;

        str.append("[");

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

    public MyQueue<T> enqueue(T value) {
        Node<T> newNode = new Node<T>(value);
        if (front == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        length++;
        return this;
    }

    public T dequeue() {
        if (front == null) {
            return null;
        }

        Node<T> current = front;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        length--;
        return current.data;
    }

    public T peek() {
        if (front == null) {
            return null;
        }

        return front.data;
    }

    public T peek(int idx) {
        if (idx >= length || front == null) {
            return null;
        }

        Node<T> current = front;

        for (int i = 0; i < idx; i++) {
            current = current.next;
        }

        return current.data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return length;
    }

    public void clear() {
        front = null;
        rear = null;
        length = 0;
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(34)
                .enqueue(7)
                .enqueue(11)
                .enqueue(14)
                .enqueue(24)
                .enqueue(34);

        System.out.println(queue);
        System.out.println(queue.dequeue());
        queue.enqueue(141);
        System.out.println(queue.dequeue());
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue.peek(0));
        System.out.println(queue.peek(1));
        System.out.println(queue.peek(2));
        System.out.println(queue);

        while(!queue.isEmpty())
            System.out.print(queue.dequeue()+" ");
    }
}
