package com.alibaba.dubbo.learn.spi;

import com.alibaba.dubbo.common.extension.SPI;

/**
 * @author zzl on 2019-09-15.
 * @description
 */
@SPI
public interface Robot {

    void sayHello();
}
