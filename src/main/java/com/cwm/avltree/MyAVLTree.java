package com.cwm.avltree;

public class MyAVLTree {

    private Node root;

    public void insert(int value) {
        root = insertNewNode(root, value);
    }

    public boolean isAVLBalanced() {
        return isBalanced(root);
    }

    private Node insertNewNode(Node root, int value) {
        if (root == null)
            return new Node(value);

        if (value < root.value)
            root.leftChild = insertNewNode(root.leftChild, value);

        else if (value > root.value)
            root.rightChild = insertNewNode(root.rightChild, value);

        else
            return root;

        setHeight(root);

        return balance(root);
    }

    private int getHeight(Node node) {
        return node == null ? -1 : node.height;
    }

    private void setHeight(Node node) {
        node.height = Math.max(getHeight(node.leftChild), getHeight(node.rightChild)) + 1;
    }

    private boolean isLeftHeavy(Node node) {
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(Node node) {
        return balanceFactor(node) < -1;
    }

    private int balanceFactor(Node node) {
        return node == null ? 0 : getHeight(node.leftChild) - getHeight(node.rightChild);
    }

    private Node balance (Node node) {
        if (isLeftHeavy(node)) {
            if (balanceFactor(node.leftChild) < 0)
                 root.leftChild = rotateLeft(node.leftChild);

            return rotateRight(node);
        }

        if (isRightHeavy(node)) {
            if (balanceFactor(node.rightChild) > 0)
                root.rightChild = rotateRight(node.rightChild);

            return rotateLeft(node);
        }

        return node;
    }

    private Node rotateLeft(Node root) {
        Node newRoot = root.rightChild;

        root.rightChild = newRoot.leftChild;

        newRoot.leftChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private Node rotateRight(Node root) {
        Node newRoot = root.leftChild;

        root.leftChild = newRoot.rightChild;

        newRoot.rightChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private boolean isBalanced(Node root) {
        if (root == null)
            return true;

        if (isLeftHeavy(root) || isRightHeavy(root))
            return false;

        return isBalanced(root);
    }

    private static class Node {
        final int value;

        int height;

        Node leftChild, rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Value: " + value;
        }
    }
}
