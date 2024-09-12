package tree;

class Node {
    public int value = 0;
    public Node left;
    public Node right;

    Node(int value) {
        this.value = value;
    }
}

public class SumOfNodes {

    public static int preorder(Node node, int num) {
        if (node == null) {
            return 0;
        }

        num = num * 10 + node.value;

        if (node.left == null && node.right == null) {
            return num;
        }
        return preorder(node.left, num) + preorder(node.right, num);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(preorder(root, 0));
    }
}