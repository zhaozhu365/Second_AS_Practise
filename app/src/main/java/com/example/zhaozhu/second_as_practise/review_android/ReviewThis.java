package com.example.zhaozhu.second_as_practise.review_android;

/**
 * author: zhaozhu
 * Created on 17/6/15
 */
public class ReviewThis {

    public static void main(String[] args) {
        Parent1 parent1 = new Parent2();
        parent1.println();
        System.out.println("--------");
        parent1.overrideMethod1();
    }


    public static class Parent1 {
        public void println() {
            System.out.println("Parent1");
        }

        public void overrideMethod1() {
            //Parent1.this.println(); //这2种写法，都会调用被子类重写的println()
            println();
        }
    }

    public static class Parent2 extends Parent1 {
        public void println() {
            System.out.println("Parent2");
            super.println();
        }
        public void overrideMethod1() {
            //Parent2.this.println();
            super.overrideMethod1();
        }
    }

}
