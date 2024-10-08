package tree;

import java.util.Scanner;
import linkedlist.queue.MyQueue;
import linkedlist.stack.MyStack;

public class Tree {
    private final Scanner scanner = new Scanner(System.in);

    private static class Node {
        Integer data;
        Node left;
        Node right;

        Node(Integer data) {
            this.data = data;
        }
    }

    private Node root;

    private void create() {
        System.out.println("Enter the root");
        int rootValue = scanner.nextInt();
        if (rootValue == -1)
            return;
        MyQueue<Node> queue = new MyQueue<>();

        root = new Node(rootValue);
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            Node node = queue.dequeue();
            System.out.printf("Enter left child of (%d) %n", node.data);
            int leftData = scanner.nextInt();
            if (leftData != -1) {
                node.left = new Node(leftData);
                queue.enqueue(node.left);
            }

            System.out.printf("Enter right child of (%d) %n", node.data);
            int rightData = scanner.nextInt();
            if (rightData != -1) {
                node.right = new Node(rightData);
                queue.enqueue(node.right);
            }
        }
    }

    /********** preorder ***********/
    public void preorder() {
        System.out.print("Preorder: ");
        preorder(root);
        System.out.println();
    }

    private void preorder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public void preorderI() {
        if (root == null) {
            return;
        }

        System.out.print("Preorder Iterative: ");
        MyStack<Node> stack = new MyStack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.data + " ");

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /********** inorder ***********/
    public void inorder() {
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();
    }

    private void inorder(Node node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public void inorderIterative() {
        if (root == null) {
            return;
        }

        System.out.print("Preorder Iterative: ");
        MyStack<Node> stack = new MyStack<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            Node node = stack.pop();
            System.out.print(node.data + " ");

            current = node.right;
        }

        System.out.println();
    }

    /********** postorder ***********/
    public void postorder() {
        System.out.print("Postorder: ");
        postorder(root);
        System.out.println();
    }

    private void postorder(Node node) {
        if (node == null) {
            return;
        }

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    /********** levelorder ***********/
    public void levelorder() {
        System.out.print("Levelorder: ");
        levelorder(root);
        System.out.println();
    }

    public void levelorder(Node root) {
        if (root == null) {
            return;
        }

        MyQueue<Node> queue = new MyQueue<>();
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            Node node = queue.dequeue();
            System.out.print(node.data + " ");
            if (node.left != null) {
                queue.enqueue(node.left);
            }
            if (node.right != null) {
                queue.enqueue(node.right);
            }
        }
    }

    /*********************/
    public int height() {
        if (root == null)
            return 0;

        return height(root);
    }

    private int height(Node node) {
        if (node == null)
            return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public int count() {
        if (root == null)
            return 0;

        return count(root);
    }

    private int count(Node node) {
        if (node == null)
            return 0;
        return 1 + count(node.left) + count(node.right);
    }

    public static void main(String[] args) {
        Tree tr = new Tree();
        tr.create();

        tr.preorder();
        tr.preorderI();
        System.out.println();

        tr.inorder();
        tr.inorderIterative();
        System.out.println();

        tr.postorder();
        System.out.println();

        tr.levelorder();
        System.out.println();

        System.out.println("Height: " + tr.height());
        System.out.println("Count: " + tr.count());
    }
}