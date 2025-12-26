package com.ethanc.throwabledemo;

// 自定义编译时异常

// 1 继承Exception
public class CustomException extends Exception {
    // 2 重写构造器
    public CustomException() {}
    public CustomException(String message) {
        super(message);
    }
}
