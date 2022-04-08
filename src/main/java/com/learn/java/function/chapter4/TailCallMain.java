package com.learn.java.function.chapter4;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;

/**
 * @author liuzhaowei
 * @date 2022/4/8 11:08
 */
@Slf4j
public class TailCallMain {

    public static void main(String[] args) {
//        Integer sum = add(1, 100000000).eval();

//        log.info("和是：{}", sum);
//        int normalAddSum = normalAdd(1, 100000000);
//        log.info("和是：{}", normalAddSum);

        // 计算斐波那契数列
        BigInteger fib = fib(100000);
        log.info("fib 100 is:{}", fib);
        log.info("fib 100 length is:{}", fib.bitLength());
    }

    /**
     * 栈溢出
     * @param x
     * @param y
     * @return
     */
    static Integer normalAdd(int x, int y){
        return y==0
                ? x
                : normalAdd(x+1, y-1);
    }

    static TailCall<Integer> add(int x, int y) {
        return y==0
                ? new TailCall.Return<>(x)
                : new TailCall.Suspend<>( () -> add(x+1, y-1));

    }

    // 计算斐波那契数列
    public static BigInteger fib(int x) {
//        return fib_(BigInteger.ZERO, BigInteger.ONE, BigInteger.valueOf(x));
        return tailCallFib_(BigInteger.ZERO, BigInteger.ONE, BigInteger.valueOf(x)).eval();
    }

    public static BigInteger fib_(BigInteger acc1, BigInteger acc2, BigInteger x){
        if (x.equals(BigInteger.ZERO)){
            return BigInteger.ZERO;
        }else if (x.equals(BigInteger.ONE)){
            return acc1.add(acc2);
        }else {
            return fib_(acc2, acc1.add(acc2), x.subtract(BigInteger.ONE));
        }
    }

    public static TailCall<BigInteger> tailCallFib_(BigInteger acc1, BigInteger acc2, BigInteger x){
        if (x.equals(BigInteger.ZERO)){
            return TailCall.ret(BigInteger.ZERO);
        }else if (x.equals(BigInteger.ONE)){
            return TailCall.ret(acc1.add(acc2));
        }else {
            return TailCall.sus(()-> tailCallFib_(acc2, acc1.add(acc2), x.subtract(BigInteger.ONE)));
        }
    }

}
