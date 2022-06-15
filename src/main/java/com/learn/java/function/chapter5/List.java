package com.learn.java.function.chapter5;

import com.learn.java.function.chapter4.TailCall;

import java.util.Arrays;

/**
 * @author liuzhaowei
 * @date 2022/4/8 16:36
 */
public abstract class List<A> {
    public abstract A head();

    public abstract List<A> tail();

    public abstract boolean isEmpty();

    public abstract List<A> setHead(A a);

    public static final List NIL = new Nil();

    public static class Nil<A> extends List<A> {

        @Override
        public A head() {
            throw new IllegalStateException("head called en empty list");
        }

        @Override
        public List<A> tail() {
            throw new IllegalStateException("tail called en empty list");
        }

        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public List<A> setHead(A a) {
            throw new IllegalStateException("setHead called on an empty list");
        }

        @Override
        public String toString() {
            return "[NIL]";
        }
    }

    public static class Cons<A> extends List<A> {
        private final A head;
        private final List<A> tail;

        public Cons(A head, List<A> tail) {
            this.head = head;
            this.tail = tail;
        }

        public List<A> cons(A a) {
            return new Cons<>(a, this);
        }

        @Override
        public A head() {
            return head;
        }

        @Override
        public List<A> tail() {
            return tail;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public List<A> setHead(A a) {
            return new Cons<>(a, tail());
        }

        @Override
        public String toString() {
            return String.format("[%sNIL]",tailCallToString(new StringBuilder(), this).eval());
        }

        private TailCall<StringBuilder> tailCallToString(StringBuilder sb, List<A> list){
            return list.isEmpty()
                    ? TailCall.ret(sb)
                    : TailCall.sus(() -> tailCallToString(sb.append(list.head()).append(","), list.tail()));
        }
    }

    @SuppressWarnings("unchecked")
    public static <A> List<A> list(){
        return NIL;
    }

    @SafeVarargs
    public static <A> List<A> list(A ... a) {
        List<A> n = list();
        for (int i=a.length-1; i>=0; i--) {
            n = new Cons<>(a[i], n);
        }
        return n;
    }

    public static <A>TailCall<List<A>> list_(List<A> acc, A[] as) {
        return as.length == 0
                ? TailCall.ret(acc)
                : TailCall.sus( ()-> list_(new Cons<>(as[as.length - 1], acc), Arrays.copyOfRange(as, 0, as.length - 1)));
    }

    public static <A> List<A> setHead(List<A> list, A a){
        return list.setHead(a);
    }
}
