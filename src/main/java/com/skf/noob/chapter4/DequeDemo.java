package com.skf.noob.chapter4;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 双向链表实现双端队列
 *
 * @author: shenkefeng
 * @date: 2023/08/03
 */
public class DequeDemo {

    public static class DoubleNode<T> {
        public T value;

        public DoubleNode<T> last;

        public DoubleNode<T> next;

        public DoubleNode(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }
    }

    public static class MyDeque<T> {
        private DoubleNode<T> head;

        private DoubleNode<T> tail;

        private int size;

        public MyDeque() {
            head = null;
            tail = null;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void pushHead(T value) {
            DoubleNode<T> doubleNode = new DoubleNode<>(value);
            if (isEmpty()) {
                head = doubleNode;
                tail = doubleNode;
            } else {
                doubleNode.next = head;
                head.last = doubleNode;
                head = doubleNode;
            }
            size++;
        }

        public void pushTail(T value) {
            DoubleNode<T> doubleNode = new DoubleNode<>(value);
            if (isEmpty()) {
                head = doubleNode;
                tail = doubleNode;
            } else {
                tail.next = doubleNode;
                doubleNode.last = tail;
                tail = doubleNode;
            }
            size++;
        }

        public T pollHead() {
            if (isEmpty()) {
                return null;
            }
            size--;
            T value = head.getValue();
            if (head == tail) {
                head = null;
                tail = null;
                return value;

            } else {
                head = head.next;
                head.last = null;
                return value;
            }
        }

        public T pollTail() {
            if (isEmpty()) {
                return null;
            }
            size--;
            T value = tail.getValue();
            if (tail == head) {
                head = null;
                tail = null;
                return value;
            } else {
                tail = tail.last;
                tail.next = null;
                return value;

            }
        }

        public T peekHead() {
            if (isEmpty()) {
                return null;
            }
            return head.getValue();
        }
        public T peekTail() {
            if (isEmpty()) {
                return null;
            }
            return tail.getValue();
        }
    }
    public static void testDeque() {
        MyDeque<Integer> myDeque = new MyDeque<>();
        Deque<Integer> test = new LinkedList<>();
        int testTime = 5000000;
        int maxValue = 200000000;
        System.out.println("测试开始！");
        for (int i = 0; i < testTime; i++) {
            if (myDeque.isEmpty() != test.isEmpty()) {
                System.out.println("Oops!");
            }
            if (myDeque.size() != test.size()) {
                System.out.println("Oops!");
            }
            double decide = Math.random();
            if (decide < 0.33) {
                int num = (int) (Math.random() * maxValue);
                if (Math.random() < 0.5) {
                    myDeque.pushHead(num);
                    test.addFirst(num);
                } else {
                    myDeque.pushTail(num);
                    test.addLast(num);
                }
            } else if (decide < 0.66) {
                if (!myDeque.isEmpty()) {
                    int num1 = 0;
                    int num2 = 0;
                    if (Math.random() < 0.5) {
                        num1 = myDeque.pollHead();
                        num2 = test.pollFirst();
                    } else {
                        num1 = myDeque.pollTail();
                        num2 = test.pollLast();
                    }
                    if (num1 != num2) {
                        System.out.println("Oops!");
                    }
                }
            } else {
                if (!myDeque.isEmpty()) {
                    int num1 = 0;
                    int num2 = 0;
                    if (Math.random() < 0.5) {
                        num1 = myDeque.peekHead();
                        num2 = test.peekFirst();
                    } else {
                        num1 = myDeque.peekTail();
                        num2 = test.peekLast();
                    }
                    if (num1 != num2) {
                        System.out.println("Oops!");
                    }
                }
            }
        }
        if (myDeque.size() != test.size()) {
            System.out.println("Oops!");
        }
        while (!myDeque.isEmpty()) {
            int num1 = myDeque.pollHead();
            int num2 = test.pollFirst();
            if (num1 != num2) {
                System.out.println("Oops!");
            }
        }
        System.out.println("测试结束！");
    }

    public static void main(String[] args) {
        testDeque();
    }

}
