package linkedlist;

class Node<T> {
    public T data;
    public Node<T> next = null;

    Node(T data) {
        this(data, null);
    }

    Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }
}

public class SinglyADT<T> {
    private Node<T> head;

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");

        Node<T> current = head;
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

    public int length() {
        Node<T> current = head;
        int count = 0;
        while (current != null) {
            current = current.next;
            count++;
        }

        return count;
    }

    private Node<T> getNode(int idx) {
        Node<T> current = head;

        for (int i = 1; i <= idx; i++) {
            current = current.next;
            if (current == null) {
                System.out.println("Index out of bound");
                return null;
            }
        }

        return current;
    }

    public T get(int idx) {
        Node<T> node = getNode(idx);
        if (node == null) {
            return null;
        }

        return node.data;
    }

    public SinglyADT<T> set(int idx, T value) {
        Node<T> node = getNode(idx);
        if (node == null) {
            return this;
        }

        node.data = value;
        return this;
    }

    public SinglyADT<T> append(T value) {
        Node<T> newNode = new Node<>(value);
        Node<T> current = head;
        if (current == null) {
            head = newNode;
            return this;
        }

        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return this;
    }

    public SinglyADT<T> prepend(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = head;
        head = newNode;
        return this;
    }

    public static void main(String[] args) {
        SinglyADT<Integer> list = new SinglyADT<>();

        list.append(4)
                .append(47)
                .append(12)
                .append(24)
                .append(55)
                .append(595)
                .prepend(5)
                .prepend(15)
                .set(4, 11);

        System.out.println(list);

        System.out.printf("%nLength : %n");
        System.out.println(list.length());

        System.out.printf("%nGet : %n");
        System.out.println(list.get(0));
        System.out.println(list.get(5));

    }
}
