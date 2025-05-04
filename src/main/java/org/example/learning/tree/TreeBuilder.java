package org.example.learning.tree;

public class TreeBuilder {
    public static TreeNode buildTree() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode leftLeft = new TreeNode(3);
        TreeNode leftRight = new TreeNode(4);
        TreeNode right = new TreeNode(5);
        TreeNode rightLeft = new TreeNode(6);
        TreeNode rightRight = new TreeNode(7);

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
