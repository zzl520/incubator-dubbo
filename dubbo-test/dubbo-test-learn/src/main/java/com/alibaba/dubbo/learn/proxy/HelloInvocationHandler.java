package com.alibaba.dubbo.learn.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zzl on 2019-09-15.
 * @description
 */
public class HelloInvocationHandler implements InvocationHandler {

    Object targetObj;

    public HelloInvocationHandler(Object obj) {
        targetObj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理前置");
        Object invoke = method.invoke(targetObj, args);
        System.out.println("代理后置");
        return invoke;
    }
}