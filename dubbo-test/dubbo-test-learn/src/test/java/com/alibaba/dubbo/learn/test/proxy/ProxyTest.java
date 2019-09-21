package com.alibaba.dubbo.learn.test.proxy;

import com.alibaba.dubbo.common.bytecode.Proxy;
import com.alibaba.dubbo.common.bytecode.Wrapper;
import com.alibaba.dubbo.learn.proxy.Hello;
import com.alibaba.dubbo.learn.proxy.HelloInvocationHandler;
import com.alibaba.dubbo.learn.proxy.HelloServiceImpl;
import com.alibaba.dubbo.learn.spi.ARobot;
import com.alibaba.dubbo.learn.spi.Robot;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @author zzl on 2019-09-15.
 * @description
 */
public class ProxyTest {


    /**
     * jdk动态代理测试
     */
    @Test
    public void jdk() {

        Hello hello = (Hello) java.lang.reflect.Proxy
                .newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{Hello.class}, new HelloInvocationHandler(new HelloServiceImpl()));

        hello.sayHello();

    }

    /**
     * javassist动态代理测试
     */
    @Test
    public void test() {
        Proxy proxy = Proxy.getProxy(Hello.class);

        Hello hello = (Hello) proxy.newInstance(new HelloInvocationHandler(new HelloServiceImpl()));
        hello.sayHello();

    }


    /**
     * wrapper会对接口进行包装，通过这个wrapper对象，可以操作被包装接口的任意实现类的方法
     */
    @Test
    public void wrapper() {

        final Wrapper wrapper = Wrapper.getWrapper(Robot.class);

        try {
            wrapper.invokeMethod(new ARobot(), "sayHello", new Class[]{}, new Object[]{});
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


}
