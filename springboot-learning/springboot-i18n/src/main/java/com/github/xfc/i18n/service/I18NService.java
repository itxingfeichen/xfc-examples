package com.github.xfc.i18n.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.xfc.i18n.mapper.I18NMapper;
import com.github.xfc.i18n.model.I18N;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * @author：jannik
 * @email: jannik@gmail.com
 * @date: 2019/6/23  13:18
 * @description:
 **/
@Service
public class I18NService extends ServiceImpl<I18NMapper, I18N> {

    private final I18NService2 i18NService2;

    public I18NService(I18NService2 i18NService2) {
        this.i18NService2 = i18NService2;
    }

    /**
     * 创建事务 {@link TransactionAspectSupport#invokeWithinTransaction(java.lang.reflect.Method, java.lang.Class, org.springframework.transaction.interceptor.TransactionAspectSupport.InvocationCallback)}
     * 隔离界别判断{@link TransactionAspectSupport#invokeWithinTransaction(java.lang.reflect.Method, java.lang.Class, org.springframework.transaction.interceptor.TransactionAspectSupport.InvocationCallback)}
     * @param i18N
     */
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.NESTED)
    public void updateByIdForTrans(I18N i18N) {
        i18N.setI18nValue("trans-test-value");
        boolean id = updateById(i18N);
        // 调用另外个有事务的方法
        i18NService2.updateByIdForTrans(i18N);
    }
}
