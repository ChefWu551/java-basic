package com.yuefeng.jvm;

/**
 * 常用的jvm指令
 */
public class _013JVMCommand {

    private static Object o1 = new Object();
    private static Object o2 = new Object();

    private static Object[] objects = new Object[10000];

    public static void main(String[] args) throws InterruptedException {
        for (int i=0; i<10000; i++) {
            Byte[] b = new Byte[1024 * 10];
            objects[i] = b;
            Thread.sleep(50);
        }

        // 线程死锁
        t1Run();
        t2Run();
    }

    /**
     * jps语法: 主要用于查看宏观的进程信息
     * jps [-q] [-mlvV] [<hostid>]
     * jps -h -help
     * jps 查看本地/远程java正在运行的进程id和进程名称
     * jps -q 只能看到进程的id
     * jps -l 进程id + 类的全类名 eg: 2306 com.yuefeng.jvm._013JVMCommand
     * jps -m 比直接jps信息更丰富，启动的时候传递的main新信息
     * jps -v 列出了每个线程id + 线程名称 + 启动时配置的参数信息 eg: 2349 _013JVMCommand -Xms10M -Xmx10M -XX:+UseG1GC -XX:+PrintGCDetails
     */


    /**
     * jstat语法：查看jvm统计信息，包含了类加载、内存、垃圾手机、jit编译等信息
     * jstat -<option> [-t] [-h<lines>] <vmid> [<interval> [<count>]]
     *      -option: 要查看的信息操作
     *          -class: 查看类装载的参数，如装载类的大小
     *          -gc: 查看gc的详情，各个区(eden,s0,s1,old,permanent/mataSpace) 已使用空间，总空间大小，GC的次数等
     *              使用举例： jstat -gc -t 2401(pid) 5000(interval) 10(times)
     *          -gccapacity: 同-gc，但是更侧重java堆区域各个区域使用到的最大、最小空间
     *          -gcutil: 同-gc，关注已使用的空间占总空间的占比
     *          -gccause: 与gcutil一致，但会额外输出导致最后一次或当前正在发生的gc原因
     *      -t: 增加时间信息，用于计算程序的总时长，可以推断出进程时间范围内的gc频率，以推断进程gc情况是否合理，是否需要增加内存
     *
     *      -h<lines>
     *
     *      vmid：
     *
     *      interval：输出的时间间隔
     *
     *      count: 输出的次数，不写默认无数次
     */
    public static void t1Run() {
        Thread t1 = new Thread(()->{
            System.out.println("线程1开始");
            synchronized (o1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (o2) {
                    System.out.println("线程1加锁中，不会被打印");
                }
            }

        });

        t1.start();
    }

    public static void t2Run() {
        Runnable t2 = new Runnable(){
            @Override
            public void run() {
                System.out.println("线程2开始");
                synchronized (o2) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (o1) {
                        System.out.println("线程2加锁中，不会被打印");
                    }
                }

            }
        };

        Thread t22 = new Thread(t2);
        t22.start();
    }


}
