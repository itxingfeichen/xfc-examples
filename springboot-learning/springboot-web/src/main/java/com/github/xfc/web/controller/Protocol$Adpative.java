//package com.github.xfc.web.controller;
//
//import com.alibaba.dubbo.common.extension.ExtensionLoader;
//
//public class Protocol$Adpative implements com.alibaba.dubbo.rpc.Protocol {
//    public void destroy() {
//        throw new UnsupportedOperationException("method public abstract void com.alibaba.dubbo.rpc.Protocol.destroy() of interface com.alibaba.dubbo.rpc.Protocol is not adaptive method!");
//    }
//
//    public int getDefaultPort() {
//        throw new UnsupportedOperationException("method public abstract int com.alibaba.dubbo.rpc.Protocol.getDefaultPort() of interface com.alibaba.dubbo.rpc.Protocol is not adaptive method!");
//    }
//
//    public com.alibaba.dubbo.rpc.Exporter export(com.alibaba.dubbo.rpc.Invoker arg0) throws com.alibaba.dubbo.rpc.RpcException {
//        com.alibaba.dubbo.common.URL url = arg0.getUrl();
//        String extName = (url.getProtocol() == null ? "dubbo" : url.getProtocol());
//        com.alibaba.dubbo.rpc.Protocol extension = (com.alibaba.dubbo.rpc.Protocol) ExtensionLoader.getExtensionLoader(com.alibaba.dubbo.rpc.Protocol.class).getExtension(extName);
//        return extension.export(arg0);
//    }
//
//    public com.alibaba.dubbo.rpc.Invoker refer(java.lang.Class arg0, com.alibaba.dubbo.common.URL arg1) throws com.alibaba.dubbo.rpc.RpcException {
//        com.alibaba.dubbo.common.URL url = arg1;
//        String extName = (url.getProtocol() == null ? "dubbo" : url.getProtocol());
//        com.alibaba.dubbo.rpc.Protocol extension = (com.alibaba.dubbo.rpc.Protocol) ExtensionLoader.getExtensionLoader(com.alibaba.dubbo.rpc.Protocol.class).getExtension(extName);
//        return extension.refer(arg0, arg1);
//    }
//}
