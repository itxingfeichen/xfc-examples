package com.github.distributed.rmi.server;

import com.github.distributed.rmi.server.service.RmiService;
import com.github.distributed.rmi.server.service.impl.RmiServiceImpl;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @author : chenxingfei
 * @date: 2019-05-01  13:00
 * @description: rmi测试server
 */
public class RmiServer {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException {

        RmiService rmiService = new RmiServiceImpl();
        LocateRegistry.createRegistry(8888);
        Naming.bind("rmi://localhost:8888/test/rmi",rmiService);

        System.out.println("服务端启动");
    }
}
