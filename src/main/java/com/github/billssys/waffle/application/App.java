package com.github.billssys.waffle.application;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static int foo() {
        int result = 0;
        for (int i=1; i<21; i++) {
            result += Math.pow(2, i);
        }
        return result;
    }

}
