package com.cwm.binarytree;

import java.util.ArrayList;
import java.util.List;

public class MyBinaryTree {

    private Node root;

    private int size = 0;

    public void insert(int value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;

            size++;

            return;
        }

        Node current = root;

        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = newNode;

                    size++;

                    break;
                }

                current = current.leftChild;
            }

            else if (value > current.value) {
                if (current.rightChild == null) {
                    current.rightChild = newNode;

                    size++;

                    break;
                }

                current = current.rightChild;
            }

            else
                return;
        }
    }

    public boolean find(int value) {
        Node current = root;

        while (current != null) {
            if (current.value == value)
                return true;

            else if (value < current.value)
                current = current.leftChild;

            else
                current = current.rightChild;
        }

        return false;
    }

    public boolean contains(int value) {
        return containsValue(root, value);
    }

    public void traversePreOrder() {
        preOrder(root);
    }

    public void traverseInOrder() {
        inOrder(root);
    }

    public void traversePostOrder() {
        postOrder(root);
    }

    public int size() {
        return size;
    }

    public int height() {
        return getHeight(root);
    }

    public int min() {
        return getMin(root);
    }

    public int max() {
        return getMax(root);
    }

    public boolean equals(MyBinaryTree tree) {
        if (tree == null)
            return false;

        return isEqual(root, tree.root);
    }

    public boolean isBinarySearchTree() {
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public List<Integer> getNodesAtDistance(int distance) {
        List<Integer> list = new ArrayList<>();

        nodesAtDistance(root, distance, list);

        return list;
    }

    public void traverseLevelOrder() {
        for (int level = 0; level < height(); level++) {

            for (Integer node : getNodesAtDistance(level))
                System.out.println(node);
        }
    }

    public int countLeaves() {
        return numberOfLeaves(root);
    }

    public boolean areSiblings(int value1, int value2) {
        return nodesAreSiblings(root, value1, value2);
    }

    private void preOrder(Node root) {
        if (root == null)
            return;

        System.out.println(root.value);
        preOrder(root.leftChild);
        preOrder(root.rightChild);
    }

    private void inOrder(Node root) {
        if (root == null)
            return;

        inOrder(root.leftChild);
        System.out.println(root.value);
        inOrder(root.rightChild);
    }

    private void postOrder(Node root) {
        if (root == null)
            return;

        postOrder(root.leftChild);
        postOrder(root.rightChild);
        System.out.println(root.value);
    }

    private int getHeight(Node root) {
        if (root == null)
            return -1;

        if (isLeaf(root))
            return 0;

        return 1 + Math.max(getHeight(root.leftChild), getHeight(root.rightChild));
    }

    private int getMin(Node root) {
        if(isLeaf(root))
            return root.value;

        int left = getMin(root.leftChild);
        int right = getMin(root.rightChild);

        return Math.min(Math.min(left, right), root.value);
    }

    private int getMax(Node root) {
        if(isLeaf(root))
            return root.value;

        int left = getMax(root.leftChild);
        int right = getMax(root.rightChild);

        return Math.max(Math.max(left, right), root.value);
    }

    private boolean isEqual(Node first, Node second) {
        if (first == null && second == null)
            return true;

        if (first != null && second != null)
            return first.value == second.value &&
                    isEqual(first.leftChild, second.leftChild)
                    && isEqual(first.rightChild, second.rightChild);

        return false;
    }

    private boolean isValid(Node root, int min, int max) {
        if (root == null)
            return true;

        if (root.value < min || root.value > max)
            return false;

        return isValid(root.leftChild, min, root.value - 1) &&
                isValid(root.rightChild, root.value + 1, max);
    }

    private void nodesAtDistance(Node root, int distance, List<Integer> list) {
        if (root == null)
            return;

        if (distance == 0) {
            list.add(root.value);

            return;
        }

        nodesAtDistance(root.leftChild, distance - 1, list);
        nodesAtDistance(root.rightChild, distance - 1, list);
    }

    private boolean isLeaf(Node node) {
        return node.leftChild == null && node.rightChild == null;
    }

    private int numberOfLeaves(Node root) {
        if (root == null)
            return 0;

        if (isLeaf(root))
            return 1;

        return numberOfLeaves(root.leftChild) + numberOfLeaves(root.rightChild);
    }

    private boolean containsValue(Node root, int value) {
        if (root == null)
            return false;

        if (root.value == value)
            return true;

        return containsValue(root.leftChild, value) ||
                containsValue(root.rightChild, value);
    }

    private boolean nodesAreSiblings(Node root, int value1, int value2) {
        if (root.leftChild == null || root.rightChild == null)
            return false;

        if (root.leftChild.value == value1 && root.rightChild.value == value2 ||
                root.leftChild.value == value2 && root.rightChild.value == value1)
            return true;

        return nodesAreSiblings(root.leftChild, value1, value2) ||
                nodesAreSiblings(root.rightChild, value1, value2);

    }

    private static class Node {
        final int value;

        Node leftChild, rightChild;

        public Node(int value) {
            this.value = value;
        }
    }
}