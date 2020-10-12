package com.share.juc.cas.demo.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * 某个对象的某个字段，atomic
 * @ClassName: AtomicIntegerFieldUpdateRunner
 * @package com.share.juc.cas.demo.atomic
 * @author: fengxing
 * @date: 2020/10/12 16:41
*/
public class AtomicIntegerFieldUpdateRunner {

    static AtomicIntegerFieldUpdater aifu = AtomicIntegerFieldUpdater.newUpdater(Student.class,"old");

    public static void main(String[] args) {
        Student stu = new Student("李磊",18);
        System.out.println(aifu.getAndIncrement(stu));
        System.out.println(aifu.getAndIncrement(stu));
        System.out.println(aifu.get(stu));
    }

    static class Student{
        private String name;
        public volatile int old;

        public Student(String name ,int old){
            this.name = name;
            this.old = old;
        }

        public String getName() {
            return name;
        }

        public int getOld() {
            return old;
        }
    }

}
