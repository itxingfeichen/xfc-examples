package com.github.xfc.autoconfigure.formatter;

/**
 * @author : chenxingfei
 * @date: 2019-08-09  07:19
 * @description: 默认格式化实现类
 */
public class DefaultFormatter implements Formatter {
    /**
     * default format for object to format a string
     *
     * @param object
     * @return
     */
    @Override
    public String format(Object object) {
        return this.getClass().getName() + " " + object;
    }
}
