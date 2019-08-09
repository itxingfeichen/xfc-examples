package com.github.xfc.autoconfigure.formatter;

/**
 * @author : chenxingfei
 * @date: 2019-08-09  07:18
 * @description: 格式化统一规范接口
 */
public interface Formatter {

    /**
     * method for format
     * @param object
     * @return
     */
    String format(Object object);
}
