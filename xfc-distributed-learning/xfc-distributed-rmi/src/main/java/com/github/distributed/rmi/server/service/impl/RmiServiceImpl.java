package com.github.distributed.rmi.server.service.impl;

import com.github.distributed.rmi.server.service.RmiService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author : chenxingfei
 * @date: 2019-05-01  12:55
 * @description:
 */
public class RmiServiceImpl extends UnicastRemoteObject implements RmiService {


    public RmiServiceImpl() throws RemoteException {
    }

    @Override
    public String testRmi(String name) throws RemoteException {
        return "server hello" + name;

    }
}
