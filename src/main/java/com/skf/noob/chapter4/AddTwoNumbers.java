package com.skf.noob.chapter4;

/**
 * 两个链表相加(https://leetcode.cn/problems/add-two-numbers/)
 * 给定两个链表的头节点head1和head2,
 * 认为从左到右是某个数字从低位到高位，返回相加之后的链表
 * 例子 4->3->6 2->5->3
 * 返回 6->8->9
 * 解释 634+352=986
 *
 * @author: shenkefeng
 * @date: 2023/08/05
 */
public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        //System.out.println(getListNodeLength(node1));
        //System.out.println(getListNodeLength(node2));

    }

    public static ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        // 获取长短链表
        ListNode longList = getListNodeLength(node1) > getListNodeLength(node2) ? node1 : node2;
        ListNode shortList = node1 == longList ? node2 : node1;
        ListNode curL = longList;
        ListNode curS = shortList;
        // lastL 用于保存长链表最后一个非空节点用
        ListNode lastL = null;
        // 进位信息
        int carry = 0;
        int curNum = 0;
        // 第一阶段: 长链表和短链表都没有走完
        while (curS != null) {
            curNum = curL.val + curS.val + carry;
            curL.val = curNum % 10;
            carry = curNum / 10;
            curS = curS.next;
            lastL = curL;
            curL = curL.next;
        }
        // 第二阶段: 此时短链表已经走完, 只走长链表
        while (curL != null) {
            curNum = curL.val +  carry;
            curL.val = curNum % 10;
            carry = curNum / 10;
            lastL = curL;
            curL = curL.next;
        }
        // 第三阶段: 判断最后的进位信息
        if (carry != 0) {
            lastL.next = new ListNode(carry);
        }
        return longList;
    }

    public static int getListNodeLength(ListNode listNode) {
        int len = 0;
        while (listNode != null) {
            listNode = listNode.next;
            len++;
        }
        return len;
    }
}
