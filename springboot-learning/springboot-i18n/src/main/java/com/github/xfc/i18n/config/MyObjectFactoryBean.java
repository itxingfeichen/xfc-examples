package com.github.xfc.i18n.config;

import com.github.xfc.i18n.model.I18N;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * FactoryBean测试
 *
 * @author jannik
 * @date 2020-02-08
 */
@Component
public class MyObjectFactoryBean implements FactoryBean<I18N> {
    @Override
    public I18N getObject() throws Exception {
        return new I18N();
    }

    @Override
    public Class<?> getObjectType() {
        return I18N.class;
    }
}