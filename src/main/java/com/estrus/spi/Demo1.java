package com.estrus.spi;


/**
 * SPI全称Service Provider Interface，是Java提供的一套用来被第三方实现或者扩展的API，它
 * 可以用来启用框架扩展和替换组件。
 */

import java.util.ServiceLoader;

/**
 * @author hanzhanzhao
 */
public class Demo1 {
    public static void main(String[] args) {
        ServiceLoader<IShout> load = ServiceLoader.load(IShout.class);
        for (IShout s : load){
            s.shout();
        }
    }
}
