package com.github.xfc.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author : chenxingfei
 * @date: 2019/9/23  18:40
 * @description: 异常测试
 */
@DisplayName("异常测试")
public class ExceptionTest {

    @Test
    @DisplayName("测试捕获的异常")
    void assertThrowsException() {
        String str = null;
        Assertions.assertThrows(NumberFormatException.class, () -> {
            Integer.valueOf(str);
        });
    }
}
