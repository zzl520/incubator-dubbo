package com.alibaba.dubbo.learn.test.spi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.learn.spi.Robot;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Protocol;
import org.junit.Test;

import java.util.List;

/**
 * @author zzl on 2019-09-15.
 * @description
 */
public class SpiTest {


    /**
     * 普通spi测试
     *
     * @throws Exception
     */
    @Test
    public void sayHello() throws Exception {
        ExtensionLoader<Robot> extensionLoader = ExtensionLoader.getExtensionLoader(Robot.class);

        /**
         * 从文件里加载所有的接口的class实现，但是只实例化需要的class类
         */
        Robot arobot = extensionLoader.getExtension("arobot");
        arobot.sayHello();
        Robot brobot = extensionLoader.getExtension("brobot");
        brobot.sayHello();

    }


    /**
     * 自适应扩展
     *
     * @throws Exception
     */
    @Test
    public void protocol() throws Exception {
        ExtensionLoader<Protocol> extensionLoader = ExtensionLoader.getExtensionLoader(Protocol.class);

        Protocol adaptiveExtension = extensionLoader.getAdaptiveExtension();

    }


    /**
     * 匹配的激活的过滤器
     *
     * @throws Exception
     */
    @Test
    public void filter() throws Exception {
        ExtensionLoader<Filter> extensionLoader = ExtensionLoader.getExtensionLoader(Filter.class);

        String[] s = new String[]{"context", "future"};
        List<Filter> activateExtension = extensionLoader.getActivateExtension(new URL("dubbo", "", 2000), s);

    }
}
