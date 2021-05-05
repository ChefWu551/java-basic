package com.yuefeng.jvm;

public class _10StackOperation {

    /**
     * 解读字节码文件的 操作码 + 操作数
     * @param k
     * @param d
     *  0 iload_1   加载int类型的局部变量k到栈中,放在索引为1的位置；
     *              xload_n(load:局部变量专用；x代表：i,d,f,a,l;； n代表：索引位置)
     *  1 iconst_2  加载int类型（也有可能是byte或者short）的常量值2到栈中；
     *              xconst_n（const：常量值专用；x代表: i,d,f,a,l; n代表：数值2，
     *              若x为i，范围为：-1~5,则使用：iconst_数值，否则会使用ipush或者ldc操作更大的数值入栈;（iconst_m1表示：-1值入栈操作）
     *              若x为l，范围为：0-1,则使用：iconst_数值，否则会使用 ldc2_w #索引位置; long类型，占两个槽
     *              若x为f，范围为：0-2范围,则使用：iconst_数值，否则会使用 ldc #索引位置;
     *              若x为d，超过为：0-1范围,则使用：iconst_数值，否则会使用 ldc2_w #索引位置; double类型，占两个槽
     *              若x为a，是null,则使用：iconst_null，否则会使用ldc #索引位置; 引用类型
     *              ）
     *  2 iadd  操作数指令相加；iadd = 96 (0x60)
     *  3 istore 4  出栈，装入局部变量表指令；xstore_n(x代表：i,l,f,d,a; n代表：索引位置)
     *  5 ldc2_w #2 <12>    long类型，值为12入栈，对应常量池索引位置为：#2
     *  8 lstore 5
     * 10 ldc #4 <chef>  引用类型，值为chef，入栈
     * 12 astore 7
     * 14 ldc #5 <10.0>     fload类型，值为10.0，入栈
     * 16 fstore 8
     * 18 ldc2_w #6 <10.0>  double类型，值为10，入栈
     * 21 dstore_2
     * 22 return
     */
    public void store(int k, double d) {
        int m = k + 2;
        long l = 12;
        String str = "chef";
        float f= 10.0f;
        d = 10;
    }
}
