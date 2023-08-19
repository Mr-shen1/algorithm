package com.skf.noob.chapter6;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树: https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @author: shenkefeng
 * @date: 2023/08/19
 */
public class Code05_ConstructBinaryFromPreorderAndInorderTraversal {
    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return g(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
    }

    public TreeNode g(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2, Map<Integer, Integer> inorderMap) {
        if (l1 > r1) {
            return null;
        }
        TreeNode head = new TreeNode(preorder[l1]);
        if (l1 == r1) {
            return head;
        }
        int headIndexInInOrderArr = inorderMap.get(preorder[l1]);
        head.left = g(preorder, l1 + 1, l1 + headIndexInInOrderArr - l2, inorder, l2, headIndexInInOrderArr - 1, inorderMap);
        head.right = g(preorder, l1 + headIndexInInOrderArr - l2 + 1, r1, inorder, headIndexInInOrderArr + 1, r2, inorderMap);
        return head;
    }

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        return f(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode f(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2) {
        if (l1 > r1) {
            return null;
        }
        TreeNode head = new TreeNode(preorder[l1]);
        if (l1 == r1) {
            return head;
        }
        int headIndexInInOrderArr = l2;
        while (preorder[l1] != inorder[headIndexInInOrderArr]) {
            headIndexInInOrderArr++;
        }
        head.left = f(preorder, l1 + 1, l1 + headIndexInInOrderArr - l2, inorder, l2, headIndexInInOrderArr - 1);
        head.right = f(preorder, l1 + headIndexInInOrderArr - l2 + 1, r1, inorder, headIndexInInOrderArr + 1, r2);
        return head;
    }
}
