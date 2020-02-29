package com.xfc.ioc.simple.construntor.service;

import org.springframework.stereotype.Service;

/**
 * A
 *
 * @author jannik
 * @date 2020-02-29
 */
@Service
public class AService {

    public AService() {
        System.out.println("AService：我被初始化了");
    }

    public String helloA(){
        return "hello A";
    }
}
