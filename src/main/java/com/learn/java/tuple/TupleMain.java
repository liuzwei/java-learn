package com.learn.java.tuple;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @author liuzhaowei
 * @date 2022/3/31 1:34
 */
public class TupleMain {
    public static void main(String[] args) {

    }

    public static Tuple<Company,Target> searchTargetByCompanyId(String companyId) {
        Company company = new Company();
        Target target = new Target();
        Collections.nCopies(10, new Company());
        return new Tuple<>(company, target);
    }

//    public <B>Map<B, List<A>> groupBy(Function<A,B> f);
}
