package org.example;

import org.example.geeksforgeeks.binarysearchtree.BinarySearchTree;
import org.example.learning.tree.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        TreeNode root = null;
//
//        root = BinarySearchTree.insert(root, 50);
//        root = BinarySearchTree.insert(root, 30);
//        root = BinarySearchTree.insert(root, 20);
//        root = BinarySearchTree.insert(root, 40);
//        root = BinarySearchTree.insert(root, 70);
//        root = BinarySearchTree.insert(root, 60);
//        root = BinarySearchTree.insert(root, 80);
//
//
//        BinarySearchTree.inOrder(root);
        Float thing = 1.0f;


        Map<Integer, LinkedList<Integer>> map = new HashMap<>();

        map.computeIfAbsent(1,k -> new LinkedList<>()).addLast(1);
        map.computeIfAbsent(1,k -> new LinkedList<>()).addLast(2);
        map.computeIfAbsent(1,k -> new LinkedList<>()).addLast(3);
        map.computeIfAbsent(2,k -> new LinkedList<>()).addLast(1);

        Map<Integer, Integer> otherMap = new HashMap<>();
        otherMap.put(1,2);
        otherMap.put(1,3);

        System.out.println(otherMap);
    }

}
