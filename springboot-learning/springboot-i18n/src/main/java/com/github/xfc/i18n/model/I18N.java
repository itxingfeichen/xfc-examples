package com.github.xfc.i18n.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author：jannik
 * @email: jannik@gmail.com
 * @date: 2019/6/23  13:16
 * @description: i18n测试
 **/
@TableName("i18n")
@Data
@Component
public class I18N implements InitializingBean, DisposableBean {

    public I18N() {
        System.out.println("构造方法=======");
    }

    private Integer id;

    private String locale;

    private String i18nType;
    private String i18nKey;
    private String i18nValue;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet=======");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Bean销毁=======");
    }
}
