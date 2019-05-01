package com.github.distributed.rmi.client;

import com.github.distributed.rmi.server.service.RmiService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author : chenxingfei
 * @date: 2019-05-01  13:00
 * @description: rmi测试server
 */
public class RmiClient {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        RmiService lookup = (RmiService) Naming.lookup("rmi://localhost:8888/test/rmi");
        System.out.println("lookup.testRmi(\"hello sever\") = " + lookup.testRmi(" hello sever "));
    }
}
