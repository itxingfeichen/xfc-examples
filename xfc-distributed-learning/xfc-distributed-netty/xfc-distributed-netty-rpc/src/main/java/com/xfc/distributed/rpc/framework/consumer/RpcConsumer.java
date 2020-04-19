package com.xfc.distributed.rpc.framework.consumer;

import com.xfc.distributed.rpc.framework.api.IRpcCalcService;
import com.xfc.distributed.rpc.framework.api.IRpcHelloService;
import com.xfc.distributed.rpc.framework.consumer.proxy.RpcProxy;

public class RpcConsumer {

    public static void main(String[] args) {

        IRpcHelloService iRpcHelloService = RpcProxy.create(IRpcHelloService.class);
        String cxf = iRpcHelloService.rpcTest("cxf");
        System.out.println(cxf);

        IRpcCalcService iRpcCalcService = RpcProxy.create(IRpcCalcService.class);

        int a = 1, b = 3;
        System.out.println("iRpcCalcService.add(a,b) = " + iRpcCalcService.add(a, b));

        System.out.println("iRpcCalcService.cub(a,b) = " + iRpcCalcService.cub(a, b));

        System.out.println("iRpcCalcService.mult(a,b) = " + iRpcCalcService.mult(a, b));

        System.out.println("iRpcCalcService.div(a,b) = " + iRpcCalcService.div(a, b));
    }
}
