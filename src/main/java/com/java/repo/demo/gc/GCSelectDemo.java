package com.java.repo.demo.gc;

/**
 * 常用 GC 搭配：
 * 1. Serial + SerialOld [客户端模式默认]
 *    -XX:+UseSerialGC
 *    新生代使用串行收集器，复制算法；老年代使用串行收集器，标记整理算法
 *
 * 2. ParNew + CMS + SerialOld
 *    -XX:+UseConcMarkSweepGC
 *    新生代使用ParNew，老年代使用CMS+SerialOld
 *
 * 3. ParNew + SerialOld (deprecated)
 *    -XX:+UseParNewGC
 *    新生代使用并行收集器，复制算法；老年代使用串行收集器，标记整理算法
 *
 * 4. ParallelScavenge + ParallelOld [服务器模式默认]
 *    -XX:+UseParallelGC 或者 -XX:+UseParallelOldGC，它们相互激活
 *    新生代使用ParallelScavenge，老年代使用ParallelOld
 *
 * 5. G1
 *    -XX:+UseG1GC
 *
 * @author GuJun
 * @date 2020/12/31
 */
public class GCSelectDemo {
    public static void main(String[] args) {
        try {
            Thread.sleep(1000000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
