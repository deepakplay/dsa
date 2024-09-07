package linkedlist;

public class SinglyADT<T> {
    private class Node<NT> {
        public NT data;
        public Node<NT> next = null;

        Node(NT data) {
            this(data, null);
        }

        Node(NT data, Node<NT> next) {
            this.data = data;
            this.next = next;
        }
    }

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

    public SinglyADT<T> insert(int idx, T value) {
        if (idx < 0 || idx > length()) {
            System.err.println("Index out of bound");
            return this;
        }

        if (idx == 0) {
            prepend(value);
            return this;
        }

        if (head == null) {
            System.out.println("List is empty");
            return this;
        }

        Node<T> curNode = head;

        for (int i = 1; i < idx; i++) {
            curNode = curNode.next;

            if (curNode == null) {
                System.out.println("Index out of bound");
                return this;
            }
        }

        Node<T> newNode = new Node<T>(value);
        newNode.next = curNode.next;
        curNode.next = newNode;
        return this;
    }

    public SinglyADT<T> delete(int idx) {
        if (idx < 0 || idx >= length() || head == null) {
            System.out.println("Index out of bound");
            return this;
        }

        if (idx == 0) {
            head = head.next;
            return this;
        }

        Node<T> currNode = head;
        for (int i = 1; i < idx; i++) {
            currNode = currNode.next;
            if (currNode == null || currNode.next == null) {
                System.out.println("Index out of bound");
                return this;
            }
        }

        currNode.next = currNode.next.next;
        return this;
    }

    public SinglyADT<T> reverse() {
        if (head == null)
            return this;

        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
        return this;
    }

    public SinglyADT<T> reverseRec() {
        if (head == null)
            return this;

        reverseRecHelper(null, head);
        return this;
    }

    private void reverseRecHelper(Node<T> prev, Node<T> current) {
        if (current == null) {
            head = prev;
            return;
        }

        Node<T> nextNode = current.next;
        current.next = prev;
        reverseRecHelper(current, nextNode);
    }

    public SinglyADT<T> rotate() {
        if (head == null || head.next == null)
            return this;

        Node<T> temp = head;
        head = head.next;
        Node<T> current = head;

        while (current.next != null) {
            current = current.next;
        }
        current.next = temp;
        temp.next = null;

        return this;
    }

    public SinglyADT<T> rotateRight() {
        if (head == null || head.next == null)
            return this;

        Node<T> current = head;
        Node<T> prev = null;
        while (current.next != null) {
            prev = current;
            current = current.next;
        }

        Node<T> temp = current;
        if (prev != null) {
            prev.next = null;
        }
        temp.next = head;
        head = temp;

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

        System.out.printf("%nInsert : %n");
        list.insert(2, 222);
        list.insert(5, 525);
        list.insert(7, 325);
        System.err.println(list);

        System.out.printf("%nDelete Idx: %n");
        list.delete(5);
        System.err.println(list);

        System.out.printf("%nReverse: %n");
        list.reverseRec();
        System.err.println(list);

        list.reverse();
        System.err.println(list);

        System.out.printf("%nRotate Left: %n");
        list.rotate();
        System.err.println(list);

        list.rotate();
        System.err.println(list);

        System.out.printf("%nRotate Right: %n");
        list.rotateRight();
        System.err.println(list);

        list.rotateRight();
        System.err.println(list);
    }
}
