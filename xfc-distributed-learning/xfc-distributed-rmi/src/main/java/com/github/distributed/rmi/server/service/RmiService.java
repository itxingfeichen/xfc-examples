package com.github.distributed.rmi.server.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author : chenxingfei
 * @date: 2019-05-01  12:53
 * @description: rmi测试案例
 */
public interface RmiService extends Remote {

    String testRmi(String name) throws RemoteException;
}
