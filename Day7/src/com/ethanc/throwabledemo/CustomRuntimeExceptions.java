package com.ethanc.throwabledemo;

// 自定义运行时异常
// 1. 首先要继承RuntimeException
public class CustomRuntimeExceptions extends RuntimeException{
    // 2. 重写构造器
    public CustomRuntimeExceptions() {}
    public CustomRuntimeExceptions(String message) {
        super(message);
    }
}
