package com.skf.noob.chapter6;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并k个有序链表: https://leetcode.cn/problems/merge-k-sorted-lists/
 *
 * @author: shenkefeng
 * @date: 2023/08/17
 */
public class Code01_MergeKSortedLists {
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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((Comparator.comparingInt(o -> o.val)));
        for (ListNode listNode : lists) {
            if (listNode != null) {
                heap.add(listNode);
            }
        }
        if (heap.isEmpty()) return null;

        // 弹出最小, 作为head
        ListNode head = heap.poll();
        ListNode pre = head;
        if (pre.next != null) {
            heap.add(pre.next);
        }
        //
        while (!heap.isEmpty()) {
            ListNode cur = heap.poll();
            pre.next = cur;
            pre = pre.next;
            if (cur.next != null) {
                heap.add(cur.next);
            }
        }
        return head;
    }
}
