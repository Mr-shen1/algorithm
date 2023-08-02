package com.skf.noob.chapter4;


public class ReserveList {
    public static class Node {
        public int value;

        public Node next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static class DoubleNode {
        public int value;

        public DoubleNode last;

        public DoubleNode next;

        public DoubleNode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }


    public static Node reserveSingleList(Node head) {
        // 定义一个pre和next
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static DoubleNode reserveDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        // 单链表
//        singleList();
        // 双链表
        doubleList();
    }

    private static void doubleList() {
        DoubleNode node1 = new DoubleNode(1);
        DoubleNode node2 = new DoubleNode(2);
        DoubleNode node3 = new DoubleNode(3);
        DoubleNode node4 = new DoubleNode(4);
        DoubleNode node5 = new DoubleNode(5);

        node1.last = null;
        node1.next = node2;
        node2.last = node1;
        node2.next = node3;
        node3.last = node2;
        node3.next = node4;
        node4.last = node3;
        node4.next = node5;
        node5.last = node4;
        node5.next = null;

        printDoubleList(node1);
        node1 = reserveDoubleList(node1);
        printDoubleList(node1);

    }

    private static void singleList() {
        Node node1 = new Node(1);
        node1.next = new Node(2);
        node1.next.next = new Node(3);
        node1 = reserveSingleList(node1);
        printSingleList(node1);
    }

    private static void printSingleList(Node node1) {
        while (node1 != null) {
            System.out.print(node1.getValue() + " ");
            node1 = node1.next;
        }
        System.out.println();
    }

    private static void printDoubleList(DoubleNode node1) {
        while (node1 != null) {
            System.out.print(node1.getValue() + " ");
            node1 = node1.next;
        }
        System.out.println();
    }

}
