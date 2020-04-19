package com.xfc.ioc.simple.construntor.service;

import org.springframework.stereotype.Service;

/**
 * BService
 *
 * @author jannik
 * @date 2020-02-29
 */
@Service
public class BService {

    private final AService aService;

    private final CService cService;

    public BService(AService aService, CService cService) {
//        System.out.println("BService：我被初始化了");
        this.aService = aService;
        this.cService = cService;
    }

    public String helloB() {
        return "hello B";
    }
}
