package com.xfc.distributed.rpc.framework.consumer;

import com.xfc.distributed.rpc.framework.consumer.proxy.RpcProxy;
import com.xfc.distributed.rpc.framework.api.IRpcHelloService;

public class RpcConsumer {

    public static void main(String[] args) {

        IRpcHelloService iRpcHelloService = RpcProxy.create(IRpcHelloService.class);
        String cxf = iRpcHelloService.rpcTest("cxf");
        System.out.println(cxf);
    }
}
