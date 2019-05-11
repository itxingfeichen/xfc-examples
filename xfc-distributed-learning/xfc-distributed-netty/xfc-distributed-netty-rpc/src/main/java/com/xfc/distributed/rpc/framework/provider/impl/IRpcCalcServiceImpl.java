package com.xfc.distributed.rpc.framework.provider.impl;

import com.xfc.distributed.rpc.framework.api.IRpcCalcService;

/**
 * @author : cxf
 * @date: 2019/5/11  9:56
 * @description:
 **/
public class IRpcCalcServiceImpl implements IRpcCalcService {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int cub(int a, int b) {
        return a - b;
    }

    @Override
    public int mult(int a, int b) {
        return a * b;
    }

    @Override
    public int div(int a, int b) {
        return a / b;
    }
}
