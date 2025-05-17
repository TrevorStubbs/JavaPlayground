package org.example.leetcode.trees;

import org.example.learning.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {
    public static int maxDepthBsf(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {
            level++;
            int currentLength = queue.size();

            for (int i = 0; i < currentLength; i++) {
                TreeNode current = queue.remove();

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }

        return level;
    }

    public static int maxDepthDsf(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepthDsf(root.left), maxDepthDsf(root.right));
    }
}
