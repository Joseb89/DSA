package com.cwm;

import com.cwm.binarytree.MyBinaryTree;

public class Main {

    public static void main(String[] args) {
        MyBinaryTree binaryTree = new MyBinaryTree();

        binaryTree.insert(7);
        binaryTree.insert(4);
        binaryTree.insert(9);
        binaryTree.insert(1);
        binaryTree.insert(6);
        binaryTree.insert(8);
        binaryTree.insert(10);

        System.out.println(binaryTree.areSiblings(8, 10));
    }
}