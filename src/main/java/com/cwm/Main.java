package com.cwm;

import com.cwm.avltree.MyAVLTree;

public class Main {

    public static void main(String[] args) {
        MyAVLTree avlTree = new MyAVLTree();

        avlTree.insert(10);
        avlTree.insert(30);
        avlTree.insert(20);

        System.out.println(avlTree);
    }
}