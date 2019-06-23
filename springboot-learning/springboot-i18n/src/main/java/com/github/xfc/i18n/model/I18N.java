package com.github.xfc.i18n.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author：jannik
 * @email: jannik@gmail.com
 * @date: 2019/6/23  13:16
 * @description: i18n测试
 **/
@TableName("i18n")
@Data
public class I18N {

    private Integer id;

    private String locale;

    private String i18nType;
    private String i18nKey;
    private String i18nValue;
}
