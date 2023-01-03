package com.learn.java.jmm;

import org.openjdk.jol.info.ClassLayout;

/**
 * 锁的升级和HashCode
 */
public class LockAndHashCode {

    public static void main(String[] args) throws Exception{
        /**
         * 未计算hashCode，可以进入偏向锁状态，也就是说，当一个对象计算过hashCode，则无法进入偏向锁状态！！！
         */
//        noHasCodeLock();
        /**
         * 在同步代码块前调用hashCode，偏向锁升级为轻量级锁
         */
//        hasCodeLock();
        /**
         * 在锁同步代码块中，调用hasCode方法，由偏向锁直接升为重量级锁
         */
        hasCodeToFatLock();
    }

    private static void noHasCodeLock() throws Exception{
        Object lock = new Object();
        /**
         * 无锁，不可偏向    non-biasable
         */
        System.out.println("无锁，不可偏向：" + ClassLayout.parseInstance(lock).toPrintable());

        Thread.sleep(5000);
        lock = new Object();
        System.out.println("无锁，可偏向： "+ClassLayout.parseInstance(lock).toPrintable());

        synchronized (lock) {
            System.out.println("偏向锁： "+ClassLayout.parseInstance(lock).toPrintable());
        }
    }

    private static void hasCodeLock() throws Exception{
        Object lock = new Object();
        /**
         * 无锁，不可偏向    non-biasable
         */
        System.out.println("无锁，不可偏向：" + ClassLayout.parseInstance(lock).toPrintable());

        Thread.sleep(5000);
        lock = new Object();
        System.out.println("无锁，可偏向： "+ClassLayout.parseInstance(lock).toPrintable());
        lock.hashCode();

        synchronized (lock) {
            System.out.println("轻量级锁： "+ClassLayout.parseInstance(lock).toPrintable());
        }
    }

    private static void hasCodeToFatLock() throws Exception{
        Object lock = new Object();
        /**
         * 无锁，不可偏向    non-biasable
         */
        System.out.println("无锁，不可偏向：" + ClassLayout.parseInstance(lock).toPrintable());

        Thread.sleep(5000);
        lock = new Object();
        System.out.println("无锁，可偏向： "+ClassLayout.parseInstance(lock).toPrintable());

        synchronized (lock) {
            System.out.println("偏向锁： "+ClassLayout.parseInstance(lock).toPrintable());
            lock.hashCode();
            System.out.println("重量级锁： "+ClassLayout.parseInstance(lock).toPrintable());
        }
    }
}
