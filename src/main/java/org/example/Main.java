package org.example;

import org.example.geeksforgeeks.binarysearchtree.BinarySearchTree;
import org.example.learning.tree.TreeNode;

public class Main {
    public static void main(String[] args) {
        TreeNode root = null;

        root = BinarySearchTree.insert(root, 50);
        root = BinarySearchTree.insert(root, 30);
        root = BinarySearchTree.insert(root, 20);
        root = BinarySearchTree.insert(root, 40);
        root = BinarySearchTree.insert(root, 70);
        root = BinarySearchTree.insert(root, 60);
        root = BinarySearchTree.insert(root, 80);


        BinarySearchTree.inOrder(root);
    }

}