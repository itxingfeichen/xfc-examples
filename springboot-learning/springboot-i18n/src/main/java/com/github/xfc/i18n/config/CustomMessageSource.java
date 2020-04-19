package com.github.xfc.i18n.config;

import com.github.xfc.i18n.model.I18N;
import com.github.xfc.i18n.service.I18NService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.context.MessageSourceProperties;
import org.springframework.context.support.AbstractResourceBasedMessageSource;

import javax.annotation.PostConstruct;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : chenxingfei
 * @date: 2019-06-22  22:26
 * @description: 自定义国际哈信息解析起
 */
//@Service("messageSource")
public class CustomMessageSource extends AbstractResourceBasedMessageSource {

    @Autowired
    private MessageSourceProperties properties;

    /**
     * 说明:</b>
     * <p>
     * 通过一个map集合存储各个语言的国际化内容</b>
     * Local: 语言类型
     * </p>
     */
    private final Map<Locale, Map<String, Object>> cacheI8nData = new ConcurrentHashMap();

    @Autowired
    private I18NService i18NService;

    @PostConstruct
    private void postConstruct() {
        List<I18N> i18NS = i18NService.list();
        i18NS.forEach(action -> {
            String actionLocale = action.getLocale();
            if (actionLocale != null && actionLocale.contains("_")) {
                String[] codeAndCountry = actionLocale.split("_");
                Locale locale = new Locale(codeAndCountry[0], codeAndCountry[1]);
                if (cacheI8nData.containsKey(locale)) {
                    cacheI8nData.get(locale).put(action.getI18nKey(), action.getI18nValue());
                } else {
                    Map<String, Object> map = new HashMap<>();
                    map.put(action.getI18nKey(), action.getI18nValue());
                    cacheI8nData.put(locale, map);
                }
            }
        });
    }


    /**
     * 在国际化内容中包含参数时需要使用,所以所有的子类必须自己实现
     *
     * @param code
     * @param locale
     * @return
     */
    @Override
    protected MessageFormat resolveCode(String code, Locale locale) {
        return new MessageFormat(code, locale);
    }


    /**
     * 根据语言获取自己存储在redis中或者在本地缓存的数据
     *
     * @param code
     * @param locale
     * @return
     */
    @Override
    protected String resolveCodeWithoutArguments(String code, Locale locale) {
        // TODO
//        return super.resolveCodeWithoutArguments(code, locale);
        Object o = cacheI8nData.get(locale).get(code);
        if (o == null) {
            return code;
        }
        return o.toString();
    }
}
