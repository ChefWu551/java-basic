package com.yuefeng.jvm;

/**
 * final类型的数据，在编译的时候就已经带着赋值信息了（constant value）
 * 非non-final类型的赋值，对于类变量来说，load阶段的prepare会进行初始化默认值，赋值阶段在clinit阶段，显式初始化
 */
public class NonFinal {

    public static int a = 5;

    public static final int b = 7;

    private final int c = 10;

    public static void main(String[] args) throws Exception{
        System.out.println(a);
        System.out.println(b);
    }
}
