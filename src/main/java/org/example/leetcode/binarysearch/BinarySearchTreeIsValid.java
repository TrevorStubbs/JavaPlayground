package org.example.leetcode.binarysearch;

import org.example.learning.tree.TreeNode;

public class BinarySearchTreeIsValid {
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (!(root.value > min && root.value < max)) {
            return false;
        }

        return isValidBST(root.left, min, root.value) && isValidBST(root.right, root.value, max);
    }

}
