package org.example.leetcode.trees;

import org.example.learning.tree.TreeNode;

public class InvertTree {
    public static TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }

        invertTree(root.left);
        invertTree(root.right);

        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;

        return root;
    }
}
