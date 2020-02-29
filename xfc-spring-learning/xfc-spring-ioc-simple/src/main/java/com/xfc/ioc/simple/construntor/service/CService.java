package com.xfc.ioc.simple.construntor.service;

import org.springframework.stereotype.Service;

/**
 * CService
 *
 * @author jannik
 * @date 2020-02-29
 */
@Service
public class CService {

    public CService() {
        System.out.println("CServic：我被初始化了");
    }
}

