package com.xfc.distributed.rpc.framework.provider.impl;

import com.xfc.distributed.rpc.framework.api.IRpcHelloService;

/**
 * @author : cxf
 * @date: 2019/5/11  9:13
 * @description:
 **/
public class IRpcHelloServiceImpl implements IRpcHelloService {
    @Override
    public String rpcTest(String name) {
        return "hello" + " " + name;
    }
}
