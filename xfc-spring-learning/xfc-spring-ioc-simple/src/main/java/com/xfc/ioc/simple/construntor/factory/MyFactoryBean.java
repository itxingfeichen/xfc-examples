package com.xfc.ioc.simple.construntor.factory;

import com.xfc.ioc.simple.construntor.service.DService;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author：jannik
 * @email: jannik@gmail.com
 * @date: 2020/3/3  22:13
 * @description: factoryBean生命周期测试
 **/
@Component
public class MyFactoryBean implements FactoryBean<DService> {
    @Override
    public DService getObject() throws Exception {
        return new DService();
    }

    @Override
    public Class<?> getObjectType() {
        return DService.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }


}
