package org.example.geeksforgeeks.binarysearchtree;

import org.example.learning.tree.TreeNode;

public class BinarySearchTree {
    public static boolean search(TreeNode root, int key) {
        if (root == null) {
            return false;
        }

        if (root.value == key) {
            return true;
        }

        if (key < root.value) {
            return search(root.left, key);
        }

        return search(root.right, key);
    }

    public static TreeNode insert(TreeNode root, int key) {
        if (root == null) {
            return new TreeNode(key);
        }

        if (root.value == key) {
            return root;
        }

        if (key < root.value) {
            return insert(root.left, key);
        }

        return insert(root.right, key);
    }

    public static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.value + " ");
            inOrder(root.right);
        }
    }

    public static TreeNode delete(TreeNode root, int key) {
        if(root == null) {
            return root;
        }

        if(root.value > key) {
            root.left = delete(root.left, key);
        } else if (root.value < key) {
            root.right = delete(root.right, key);
        } else {
            if(root.left == null) {
                return root.right;
            }

            if(root.right == null) {
                return root.left;
            }

            TreeNode successor = getSuccessor(root);
            root.value = successor.value;
            root.right = delete(root.right, key);
        }

        return root;
    }

    private static TreeNode getSuccessor(TreeNode current){
        // best to do a null check first
        current = current.right;
        while(current!=null && current.left !=null){
            current = current.left;
        }

        return current;
    }

}
