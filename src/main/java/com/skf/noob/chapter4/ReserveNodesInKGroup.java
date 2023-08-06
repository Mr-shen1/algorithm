package com.skf.noob.chapter4;


/**
 * K个一组翻转链表(https://leetcode.cn/problems/reverse-nodes-in-k-group/)
 *
 * @author: shenkefeng
 * @date: 2023/08/05
 */
public class ReserveNodesInKGroup {

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

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = getKGroupEnd(start, k);
        if (end == null) {
            return head;
        }
        // 第一组凑齐了！
        head = end;
        reserveListNode(start, end);
        // 上一组的结尾节点
        ListNode lastEnd = start;
        while (lastEnd.next != null) {
            start = lastEnd.next;
            end = getKGroupEnd(start, k);
            if (end == null) {
                return head;
            }
            reserveListNode(start, end);

            lastEnd.next = end;
            lastEnd = start;
        }
        return head;
    }

    /**
     * 获取链表第k个节点, 不足k直接返回原节点
     *
     * @param start start
     * @param k     位置
     * @return result
     */
    public static ListNode getKGroupEnd(ListNode start, int k) {
        // 第一个条件是依次取下一个
        // 第二个条件是判断如果start后没有k个节点时, 直接返回start
        while (--k != 0 && start != null) {
            start = start.next;
        }
        return start;
    }

    /**
     * 反转
     *
     * @param start start
     * @param end   end
     */
    public static void reserveListNode(ListNode start, ListNode end) {
        // 保存end的下一个节点
        end = end.next;
        ListNode pre = null;
        ListNode cur = start;
        ListNode next;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }


    public static void main(String[] args) {
        //ListNode node1 = new ListNode(1);
        //ListNode node2 = new ListNode(2);
        //ListNode node3 = new ListNode(3);
        //ListNode node4 = new ListNode(4);
        //node1.next = node2;
        //node2.next = node3;
        //node3.next = node4;
        //
        //ListNode kGroupEnd = getKGroupEnd(node1, 3);
        //reserveListNode(node1, kGroupEnd);

    }
}
