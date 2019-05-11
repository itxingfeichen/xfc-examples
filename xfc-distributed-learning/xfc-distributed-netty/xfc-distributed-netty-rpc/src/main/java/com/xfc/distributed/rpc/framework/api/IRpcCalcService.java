package com.xfc.distributed.rpc.framework.api;

/**
 * @author : cxf
 * @date: 2019/5/11  9:55
 * @description: rpc接口
 **/
public interface IRpcCalcService {

    int add(int a, int b);

    int cub(int a, int b);

    int mult(int a, int b);

    int div(int a, int b);
}
