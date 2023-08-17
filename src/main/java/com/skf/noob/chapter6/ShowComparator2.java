package com.skf.noob.chapter6;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @author: shenkefeng
 * @date: 2023/08/17
 */
public class ShowComparator2 {
    public static class Student {
        String name;

        int id;
        int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    ", age=" + age +
                    '}';
        }
    }
    public static class MyCompatator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
    public static void main(String[] args) {
        // 默认是小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(6);
        heap.add(2);
        heap.add(3);
        heap.add(1);
        heap.add(5);
        System.out.println(heap.peek());
        heap.add(0);
        System.out.println(heap.peek());
        System.out.println("==========");
        while (!heap.isEmpty()) {
            System.out.println(heap.poll());
        }
        System.out.println("==========");
        System.out.println("==========");

        // 使用比较器, 大根堆
        PriorityQueue<Integer> bigHeap = new PriorityQueue<>(new MyCompatator());
        bigHeap.add(6);
        bigHeap.add(2);
        bigHeap.add(3);
        bigHeap.add(1);
        bigHeap.add(5);
        System.out.println(bigHeap.peek());
        bigHeap.add(8);
        System.out.println(bigHeap.peek());
        System.out.println("==========");
        while (!bigHeap.isEmpty()) {
            System.out.println(bigHeap.poll());
        }
        System.out.println("==========");
        System.out.println("==========");
        PriorityQueue<Student> studentHeap = getStudentHeap();
        while (!studentHeap.isEmpty()) {
            System.out.println(studentHeap.poll());
        }

        TreeSet<Student> treeSet = new TreeSet<>(Comparator.comparingInt(o -> o.id));
        // ...略
    }

    private static PriorityQueue<Student> getStudentHeap() {
        PriorityQueue<Student> studentHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.id));
        Student s1 = new Student("张三", 4, 23);
        Student s2 = new Student("张三", 3, 21);
        Student s3 = new Student("张三", 1, 15);
        Student s4 = new Student("张三", 5, 17);
        Student s5 = new Student("张三", 2, 5);
        Student s6 = new Student("张三", 6, 5);
        studentHeap.add(s1);
        studentHeap.add(s2);
        studentHeap.add(s3);
        studentHeap.add(s4);
        studentHeap.add(s5);
        studentHeap.add(s6);
        return studentHeap;
    }
}
