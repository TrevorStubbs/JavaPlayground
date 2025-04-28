package org.example;

import org.example.dailypractice.DailyPracticeApril22;

public class TreeBuilder {
    public static TreeNode buildTree() {
        TreeNode root = new TreeNode();
        TreeNode left = new TreeNode();
        TreeNode leftLeft = new TreeNode();
        TreeNode leftRight = new TreeNode();
        TreeNode right = new TreeNode();
        TreeNode rightLeft = new TreeNode();
        TreeNode rightRight = new TreeNode();

        root.value = 1;
        root.left = left;
        root.right = right;

        left.value = 2;
        left.left = leftLeft;
        leftLeft.value = 3;
        left.right = leftRight;
        leftRight.value = 4;

        right.value = 5;
        right.left = rightLeft;
        rightLeft.value = 6;
        right.right = rightRight;
        rightRight.value = 7;

        return root;
    }
}
