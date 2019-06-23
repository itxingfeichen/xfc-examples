//package com.github.xfc.i18n.config;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.context.MessageSourceProperties;
//import org.springframework.context.MessageSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.support.AbstractMessageSource;
//import org.springframework.context.support.ResourceBundleMessageSource;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//
//import java.text.MessageFormat;
//import java.time.Duration;
//import java.util.Locale;
//
///**
// * @author : chenxingfei
// * @date: 2019-06-22  16:40
// * @description: 重写message
// */
//@Service("messageSource")
//public class OverrideMessageResource extends AbstractMessageSource {
//
//
//    public OverrideMessageResource(@Qualifier MessageSourceProperties properties) {
//        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//        if (StringUtils.hasText(properties.getBasename())) {
//            messageSource.setBasenames(StringUtils.commaDelimitedListToStringArray(
//                    StringUtils.trimAllWhitespace(properties.getBasename())));
//        }
//        if (properties.getEncoding() != null) {
//            messageSource.setDefaultEncoding(properties.getEncoding().name());
//        }
//        messageSource.setFallbackToSystemLocale(properties.isFallbackToSystemLocale());
//        Duration cacheDuration = properties.getCacheDuration();
//        if (cacheDuration != null) {
//            messageSource.setCacheMillis(cacheDuration.toMillis());
//        }
//        messageSource.setAlwaysUseMessageFormat(properties.isAlwaysUseMessageFormat());
//        messageSource.setUseCodeAsDefaultMessage(properties.isUseCodeAsDefaultMessage());
//    }
//
//    /**
//     * Subclasses must implement this method to resolve a message.
//     * <p>Returns a MessageFormat instance rather than a message String,
//     * to allow for appropriate caching of MessageFormats in subclasses.
//     * <p><b>Subclasses are encouraged to provide optimized resolution
//     * for messages without arguments, not involving MessageFormat.</b>
//     * See the {@link #resolveCodeWithoutArguments} javadoc for details.
//     *
//     * @param code   the code of the message to resolve
//     * @param locale the locale to resolve the code for
//     *               (subclasses are encouraged to support internationalization)
//     * @return the MessageFormat for the message, or {@code null} if not found
//     * @see #resolveCodeWithoutArguments(String, Locale)
//     */
//    @Override
//    protected MessageFormat resolveCode(String code, Locale locale) {
//        return new MessageFormat(code, locale);
//    }
//
//    /**
//     * Subclasses can override this method to resolve a message without arguments
//     * in an optimized fashion, i.e. to resolve without involving a MessageFormat.
//     * <p>The default implementation <i>does</i> use MessageFormat, through
//     * delegating to the {@link #resolveCode} method. Subclasses are encouraged
//     * to replace this with optimized resolution.
//     * <p>Unfortunately, {@code java.text.MessageFormat} is not implemented
//     * in an efficient fashion. In particular, it does not detect that a message
//     * pattern doesn't contain argument placeholders in the first place. Therefore,
//     * it is advisable to circumvent MessageFormat for messages without arguments.
//     *
//     * @param code   the code of the message to resolve
//     * @param locale the locale to resolve the code for
//     *               (subclasses are encouraged to support internationalization)
//     * @return the message String, or {@code null} if not found
//     * @see #resolveCode
//     * @see MessageFormat
//     */
//    @Override
//    protected String resolveCodeWithoutArguments(String code, Locale locale) {
////        return "重写哦快嘛？";
//        return null;
//    }
//}
