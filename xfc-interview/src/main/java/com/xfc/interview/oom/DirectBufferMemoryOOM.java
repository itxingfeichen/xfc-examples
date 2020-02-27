package com.xfc.interview.oom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author：jannik
 * @email: jannik@gmail.com
 * @date: 2020/2/25  20:26
 * @description: Exception in thread "main" java.lang.OutOfMemoryError: Direct buffer memory
 **/
public class DirectBufferMemoryOOM {

    public static void main(String[] args) {

        ByteBuffer.allocateDirect(6 * 1024 * 1024);
    }
}
