package com.yuefeng.jvm;

/**
 * 设置栈的大小：-Xss256k -XX:+PrintGCDetails
 *
 */
public class StackOverflowTest {
    private static int count = 1;

    public static void main(String[] args) {
        System.out.println(count);
        count++;
        main(args);
    }
}
