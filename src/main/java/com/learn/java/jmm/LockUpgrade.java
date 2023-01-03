package com.learn.java.jmm;

import org.openjdk.jol.info.ClassLayout;

/**
 * 锁升级测试
 */
public class LockUpgrade {

    public static void main(String[] args) throws Exception{
        Object lock = new Object();
        System.out.println("不可偏向 non-biasable :"+ClassLayout.parseInstance(lock).toPrintable());
        /**
         * OFF  SZ   TYPE DESCRIPTION               VALUE
         *   0   8        (object header: mark)     0x0000000000000001 (non-biasable; age: 0)
         *   8   4        (object header: class)    0xf80001e5
         *  12   4        (object alignment gap)
         */
        synchronized (lock){
            System.out.println("轻量级锁 thin lock :"+ClassLayout.parseInstance(lock).toPrintable());
        }
        /**
         * OFF  SZ   TYPE DESCRIPTION               VALUE
         *   0   8        (object header: mark)     0x0000000d988ff7e8 (thin lock: 0x0000000d988ff7e8)
         *   8   4        (object header: class)    0xf80001e5
         *  12   4        (object alignment gap)
         */
        // 默认4秒后启用偏向锁
        Thread.sleep(5000);
        lock = new Object();
        System.out.println("可偏向  biasable " + ClassLayout.parseInstance(lock).toPrintable());
        /**
         * OFF  SZ   TYPE DESCRIPTION               VALUE
         *   0   8        (object header: mark)     0x0000000000000005 (biasable; age: 0)
         *   8   4        (object header: class)    0xf80001e5
         *  12   4        (object alignment gap)
         */
        synchronized (lock) {
            System.out.println("持有  biased " + ClassLayout.parseInstance(lock).toPrintable());
        }
        /**
         * OFF  SZ   TYPE DESCRIPTION               VALUE
         *   0   8        (object header: mark)     0x000001ecca783805 (biased: 0x000000007b329e0e; epoch: 0; age: 0)
         *   8   4        (object header: class)    0xf80001e5
         *  12   4        (object alignment gap)
         */
        System.out.println("偏向锁不释放  biased " + ClassLayout.parseInstance(lock).toPrintable());
        /**
         * OFF  SZ   TYPE DESCRIPTION               VALUE
         *   0   8        (object header: mark)     0x000002a60bf07005 (biased: 0x00000000a982fc1c; epoch: 0; age: 0)
         *   8   4        (object header: class)    0xf80001e5
         *  12   4        (object alignment gap)
         */
        synchronized (lock) {
            System.out.println("再次持有  biased " + ClassLayout.parseInstance(lock).toPrintable());
        }


        Object finalLock = lock;
        Thread thread1 = new Thread(() -> {
            synchronized (finalLock) {
                System.out.println("thread1 轻量级锁 " + ClassLayout.parseInstance(finalLock).toPrintable());
            }
            /**
             * OFF  SZ   TYPE DESCRIPTION               VALUE
             *   0   8        (object header: mark)     0x000000681eeff4a0 (thin lock: 0x000000681eeff4a0)
             *   8   4        (object header: class)    0xf80001e5
             *  12   4        (object alignment gap)
             */

            System.out.println("thread1 不可偏向" + ClassLayout.parseInstance(finalLock).toPrintable());
            /**
             * OFF  SZ   TYPE DESCRIPTION               VALUE
             *   0   8        (object header: mark)     0x0000000000000001 (non-biasable; age: 0)
             *   8   4        (object header: class)    0xf80001e5
             *  12   4        (object alignment gap)
             */
        });
        thread1.start();
        Thread.sleep(200);

        Thread thread2 = new Thread(() -> {
            synchronized (finalLock) {
                System.out.println("thread2 轻量级锁 " + ClassLayout.parseInstance(finalLock).toPrintable());
                /**
                 * OFF  SZ   TYPE DESCRIPTION               VALUE
                 *   0   8        (object header: mark)     0x000000681eeff538 (thin lock: 0x000000681eeff538)
                 *   8   4        (object header: class)    0xf80001e5
                 *  12   4        (object alignment gap)
                 */
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("thread2 重量级锁 " + ClassLayout.parseInstance(finalLock).toPrintable());
                /**
                 * OFF  SZ   TYPE DESCRIPTION               VALUE
                 *   0   8        (object header: mark)     0x0000021ecff433ba (fat lock: 0x0000021ecff433ba)
                 *   8   4        (object header: class)    0xf80001e5
                 *  12   4        (object alignment gap)
                 */
            }
        });
        thread2.start();
        Thread.sleep(500);
        synchronized (finalLock) {
            System.out.println("重量级锁 "+ ClassLayout.parseInstance(finalLock).toPrintable());
        }
        /**
         * OFF  SZ   TYPE DESCRIPTION               VALUE
         *   0   8        (object header: mark)     0x0000021ecff433ba (fat lock: 0x0000021ecff433ba)
         *   8   4        (object header: class)    0xf80001e5
         *  12   4        (object alignment gap)
         */

        System.out.println("不可偏向 "+ ClassLayout.parseInstance(finalLock).toPrintable());
    }
}
