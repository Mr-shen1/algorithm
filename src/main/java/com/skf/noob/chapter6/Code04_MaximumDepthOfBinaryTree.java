package com.skf.noob.chapter6;

/**
 * 找树的最大深度: https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 *
 * @author: shenkefeng
 * @date: 2023/08/19
 */
public class Code04_MaximumDepthOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return  0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}