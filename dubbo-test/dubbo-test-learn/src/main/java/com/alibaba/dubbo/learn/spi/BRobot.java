package com.alibaba.dubbo.learn.spi;

/**
 * @author zzl on 2019-09-15.
 * @description
 */
public class BRobot implements Robot {
    @Override
    public void sayHello() {
        System.out.println("b robot");
    }
}
