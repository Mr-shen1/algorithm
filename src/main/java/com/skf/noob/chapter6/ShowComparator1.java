package com.skf.noob.chapter6;

import java.util.Arrays;

/**
 * @author: shenkefeng
 * @date: 2023/08/17
 */
public class ShowComparator1 {
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

    public static void main(String[] args) {
        int[] arr = {2, 35, 5, 23, 5, 7, 86, 43, 4, 2, 45, 76, 87, 98};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        Student s1 = new Student("张三", 4, 23);
        Student s2 = new Student("张三", 3, 21);
        Student s3 = new Student("张三", 1, 15);
        Student s4 = new Student("张三", 5, 17);
        Student s5 = new Student("张三", 2, 5);
        Student s6 = new Student("张三", 6, 5);

        Student[] students = {s1, s2, s3, s4, s5, s6};
        Arrays.sort(students, (o1, o2) -> {
            // 如果返回负数，则第一个参数排在前面
            // 如果返回正数，则第二个参数排在前面
            // 如果返回0，前后无所谓
            // 以下表示先根据age从小到大排序，如果age相同，再根据id由大到小排序
            if (o1.age == o2.age) {
                return o2.id - o1.id;
            }
            return o1.age - o2.age;
        });
        System.out.println(Arrays.toString(students));
    }
}
