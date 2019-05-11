package com.xfc.distributed.rpc.framework.registry;

import com.xfc.distributed.rpc.framework.core.msg.InvokerMsg;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class RegistryHandler extends ChannelInboundHandlerAdapter {

    /**
     * 通过map集合模拟注册中心
     */
    public static ConcurrentHashMap<String, Object> registryMap = new ConcurrentHashMap<>(16);

    /**
     * 构造存储类名称的容器
     */
    private static List<String> classCache = new ArrayList<>();


    public RegistryHandler() {
        scanAllClass("com.xfc.distributed.rpc.framework.provider");
        doRegistry();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        InvokerMsg invokerMsg = (InvokerMsg) msg;
        Object invoke = new Object();
        Object o = registryMap.get(invokerMsg.getServiceName());
        if (o != null) {

            try {
                Method method = o.getClass().getDeclaredMethod(invokerMsg.getMethodName(),invokerMsg.getParamsList());
                invoke = method.invoke(o, invokerMsg.getParams());
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        ctx.writeAndFlush(invoke);
        ctx.close();


    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }

    /**
     * 扫描所有的类
     *
     * @param packageName
     */
    private void scanAllClass(String packageName) {

        URL resource = this.getClass().getClassLoader().getResource(packageName.replaceAll("\\.", "/"));
        File dir = new File(resource.getFile());
        for (File file : dir.listFiles()) {

            if (file.isDirectory()) {

                scanAllClass(packageName + "." + file.getName());
            } else {
                classCache.add(packageName + "." + file.getName().replace(".class", "").trim());
            }
        }

    }

    /**
     * 注册
     */
    private void doRegistry() {

        try {
            if (classCache != null && classCache.size() > 0) {

                for (String className : classCache) {
                    Class<?> aClass = Class.forName(className);
                    Class<?> anInterface = aClass.getInterfaces()[0];
                    registryMap.put(anInterface.getName(), aClass.newInstance());
                }

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
