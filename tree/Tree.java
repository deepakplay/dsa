package tree;

import java.util.Scanner;
import linkedlist.queue.MyQueue;

public class Tree {
    private Scanner scanner = new Scanner(System.in);

    private class Node {
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
            Integer leftData = scanner.nextInt();
            if (leftData != -1) {
                node.left = new Node(leftData);
                queue.enqueue(node.left);
            }

            System.out.printf("Enter right child of (%d) %n", node.data);
            Integer rightData = scanner.nextInt();
            if (rightData != -1) {
                node.right = new Node(rightData);
                queue.enqueue(node.right);
            }
        }
    }

    /***********/
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

    /***********/
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

    /***********/
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

    public void levelorder() {
        System.out.print("Levelorder: ");
        levelorder(root);
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

    public static void main(String[] args) {
        Tree tr = new Tree();
        tr.create();
        tr.preorder();
        tr.inorder();
        tr.postorder();
        tr.levelorder();
    }
}