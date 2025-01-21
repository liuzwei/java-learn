package com.learn.java.thread;

public class MachineProcessor {
    /**
     * 获取机器的cpu数量
     * @return
     */
    public static int machineProcessor(){

        return Runtime.getRuntime().availableProcessors();
    }

    public static void main(String[] args) {
        System.out.println(machineProcessor());
    }
}
