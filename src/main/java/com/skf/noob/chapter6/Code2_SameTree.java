package com.skf.noob.chapter6;

/**
 * 两棵树的结构是否完全相同: https://leetcode.cn/problems/same-tree/
 *
 * @author: shenkefeng
 * @date: 2023/08/17
 */
public class Code2_SameTree {
    public static class TreeNode {
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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 有一棵树为空, 一颗不为空
        if (p == null ^ q == null) {
            return false;
        }
        // 两棵树都为空
        if (p == null && q == null) {
            return true;
        }
        // 两棵树都不为空
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
