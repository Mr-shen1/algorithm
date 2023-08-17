package com.skf.noob.chapter6;

/**
 * @author: shenkefeng
 * @date: 2023/08/17
 */
public class TraversalBinaryTree {

    public static class Node {
        Node left;
        int val;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * 先序: 头 左 右
     *
     * @param head head
     */
    public static void pre(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.val);
        pre(head.left);
        pre(head.right);
    }

    /**
     * 中序: 左 头 右
     *
     * @param head head
     */
    public static void in(Node head) {
        if (head == null) {
            return;
        }
        in(head.left);
        System.out.println(head.val);
        in(head.right);
    }

    /**
     * 后序: 左 右 头
     *
     * @param head head
     */
    public static void post(Node head) {
        if (head == null) {
            return;
        }
        post(head.left);
        post(head.right);
        System.out.println(head.val);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        pre(head);
        System.out.println();
        in(head);
        System.out.println();
        post(head);
    }
}
