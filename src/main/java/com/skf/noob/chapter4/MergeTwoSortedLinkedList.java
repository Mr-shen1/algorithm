package com.skf.noob.chapter4;


/**
 * 合并两个有序链表(https://leetcode.cn/problems/merge-two-sorted-lists/)
 *
 * @author: shenkefeng
 * @date: 2023/08/05
 */
public class MergeTwoSortedLinkedList {

    public class ListNode {
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

    }
    public static ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        // 边界判断
        if (node1 == null || node2 == null) {
            return node1 == null ? node2 : node1;
        }
        // 获取两个链表第一个值小的那个链表, 最后返回
        ListNode resultListNode = node1.val <= node2.val ? node1 : node2;
        ListNode cur1 = resultListNode.next;
        ListNode cur2 = resultListNode == node1 ? node2 : node1;
        ListNode pre = resultListNode;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                pre.next = cur1;
                cur1 = cur1.next;
            } else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }
        // 处理最后情况
        pre.next = cur1 != null ? cur1 : cur2;
        return resultListNode;
    }
}