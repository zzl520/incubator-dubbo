package com.alibaba.dubbo.learn.proxy;

/**
 * @author zzl on 2019-09-15.
 * @description
 */
public class HelloServiceImpl implements Hello {
    @Override
    public void sayHello() {
        System.out.println("HelloServiceImpl");
    }
}
