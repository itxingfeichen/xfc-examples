package com.github.xfc.i18n.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.xfc.i18n.mapper.I18NMapper;
import com.github.xfc.i18n.model.I18N;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author：jannik
 * @email: jannik@gmail.com
 * @date: 2019/6/23  13:18
 * @description:
 **/
@Service
public class I18NService2 extends ServiceImpl<I18NMapper, I18N> {

    @Transactional(rollbackFor = Exception.class)
    public boolean updateByIdForTrans(I18N i18N) {

        i18N.setI18nKey("transTest");
        boolean b = updateById(i18N);
//        int i = 1 / 0;
        return b;
    }
}
