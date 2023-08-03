package com.skf.noob.chapter4;

import java.util.Stack;

/**
 * 使用链表实现栈
 *
 * @author: skf
 * @date: 2023/08/03
 */
public class StackDemo {

    public static class Node<T> {
        private T value;

        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }
    }

    public static class MyStack<T> {
        private Node<T> head;

        private static Integer size;

        public MyStack() {
            head = null;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void push(T value) {
            Node<T> node = new Node<>(value);
            if (head == null) {
                head = node;
            } else {
                node.next = head;
                head = node;
            }
            size++;
        }

        public T pop() {
            if (isEmpty()) {
                return null;
            } else {
                T result = head.getValue();
                head = head.next;
                size--;
                return result;
            }
        }

        public T peek() {
            if (isEmpty()) {
                return null;
            } else {
                return head.getValue();
            }
        }
    }

    public static void testStack() {
        MyStack<Integer> myStack = new MyStack<>();
        Stack<Integer> test = new Stack<>();
        int testTime = 5000000;
        int maxValue = 200000000;
        System.out.println("测试开始！");
        for (int i = 0; i < testTime; i++) {
            if (myStack.isEmpty() != test.isEmpty()) {
                System.out.println("Oops!");
            }
            if (myStack.size() != test.size()) {
                System.out.println("Oops!");
            }
            double decide = Math.random();
            if (decide < 0.33) {
                int num = (int) (Math.random() * maxValue);
                myStack.push(num);
                test.push(num);
            } else if (decide < 0.66) {
                if (!myStack.isEmpty()) {
                    int num1 = myStack.pop();
                    int num2 = test.pop();
                    if (num1 != num2) {
                        System.out.println("Oops!");
                    }
                }
            } else {
                if (!myStack.isEmpty()) {
                    int num1 = myStack.peek();
                    int num2 = test.peek();
                    if (num1 != num2) {
                        System.out.println("Oops!");
                    }
                }
            }
        }
        if (myStack.size() != test.size()) {
            System.out.println("Oops!");
        }
        while (!myStack.isEmpty()) {
            int num1 = myStack.pop();
            int num2 = test.pop();
            if (num1 != num2) {
                System.out.println("Oops!");
            }
        }
        System.out.println("测试结束！");
    }
    public static void main(String[] args) {
        testStack();
    }
}
