package com.learn.java.function.validateemail;

import com.learn.java.function.practice3_2.Case;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;
import java.util.regex.Pattern;


/**
 * @author liuzhaowei
 * @date 2022/4/1 21:51
 */
@Slf4j
public class EmailValidation {
    static Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$");

//    static Function<String, Result<String>> emailChecker = s ->
//            s == null ? Result.failure("email must not be null") :
//                    s.length()==0 ? Result.failure("email must not be empty") :
//                            emailPattern.matcher(s).matches() ? Result.success(s) :
//                                    Result.failure("email "+ s +" is invalid! ");

    static Function<String, Result<String>> emailCheckers = s -> Case.match(
            Case.mcase(()-> Result.success(s)),
            Case.mcase(()-> s == null , ()->Result.failure("email must not be null")),
            Case.mcase(() -> s.length()==0 , ()->Result.failure("email must not be empty")),
            Case.mcase(() -> !emailPattern.matcher(s).matches(), () -> Result.failure("email "+s+" is invalid"))
    );


    public static void main(String[] args) {
        emailCheckers.apply(null).bind(success, failure);
        emailCheckers.apply("").bind(success, failure);
        emailCheckers.apply("zhaowei#com.cn.email").bind(success, failure);
        emailCheckers.apply("zhaowei@github.com").bind(success, failure);
    }

    static Effect<String> success = s -> {
        log.info("发送邮件到{}", s);
    };
    static Effect<String> failure = s -> {
        log.info("Error msg:{}", s);
    };
}
