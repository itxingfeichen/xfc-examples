package com.github.xfc.i18n.config;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.context.support.AbstractResourceBasedMessageSource;

import java.text.MessageFormat;
import java.util.Locale;

/**
 * @author : chenxingfei
 * @date: 2019-06-22  22:26
 * @description: 自定义国际哈信息解析起
 */
public class CustomMessageSource extends AbstractResourceBasedMessageSource implements BeanClassLoaderAware {
    /**
     * Callback that supplies the bean {@link ClassLoader class loader} to
     * a bean instance.
     * <p>Invoked <i>after</i> the population of normal bean properties but
     * <i>before</i> an initialization callback such as
     * {@link InitializingBean InitializingBean's}
     * {@link InitializingBean#afterPropertiesSet()}
     * method or a custom init-method.
     *
     * @param classLoader the owning class loader
     */
    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {

    }

    /**
     * Subclasses must implement this method to resolve a message.
     * <p>Returns a MessageFormat instance rather than a message String,
     * to allow for appropriate caching of MessageFormats in subclasses.
     * <p><b>Subclasses are encouraged to provide optimized resolution
     * for messages without arguments, not involving MessageFormat.</b>
     * See the {@link #resolveCodeWithoutArguments} javadoc for details.
     *
     * @param code   the code of the message to resolve
     * @param locale the locale to resolve the code for
     *               (subclasses are encouraged to support internationalization)
     * @return the MessageFormat for the message, or {@code null} if not found
     * @see #resolveCodeWithoutArguments(String, Locale)
     */
    @Override
    protected MessageFormat resolveCode(String code, Locale locale) {
        return null;
    }
}
