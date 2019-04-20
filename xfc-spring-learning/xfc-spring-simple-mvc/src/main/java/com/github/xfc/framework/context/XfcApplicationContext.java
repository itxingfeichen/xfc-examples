package com.github.xfc.framework.context;

import com.github.xfc.framework.annotation.XfcAutowired;
import com.github.xfc.framework.annotation.XfcController;
import com.github.xfc.framework.annotation.XfcService;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : chenxingfei
 * @date: 2019-04-20  17:08
 * @description: Bean上下文管理器
 */
public class XfcApplicationContext {

    private ConcurrentHashMap<String, Object> beanMap = new ConcurrentHashMap<String, Object>(16);

    private Properties config;

    /**
     * cacje class
     */
    private List<String> classCache = new ArrayList<String>();


    public XfcApplicationContext(String location) {
        // 定位
        InputStream i = this.getClass().getResourceAsStream(location);
        config = new Properties();
        try {
            // 加载
            config.load(i);
            // 注册，相当于把所有的class找出来保存
            String scanPackage = config.getProperty("scanPackage");
            doRegister(scanPackage);
            // 初始化
            doCreateBean();
            // 注入
            populate();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Properties getConfig() {
        return config;
    }

    public void setConfig(Properties config) {
        this.config = config;
    }

    /**
     * @return
     */
    public Map<String, Object> getAllBeans() {
        return beanMap;
    }

    /**
     * 注册，将符合条件的class找出来，注册到缓存中去
     *
     * @param scanPackage
     */
    private void doRegister(String scanPackage) {
        // 获取到文件路径
        URL resource = this.getClass().getClass().getResource("/" + scanPackage.replaceAll("\\.", "/"));
        File fileDir = new File(resource.getFile());
        for (File file : fileDir.listFiles()) {
            if (file.isDirectory()) {
                doRegister(scanPackage + "." + file.getName());
            } else {
                // 替换.class，反射创建对象是不需要.class
                classCache.add(scanPackage + "." + file.getName().replaceAll(".class", ""));
            }

        }
    }


    /**
     * 开始初始化
     */
    private void doCreateBean() {

        try {
            if (classCache.size() < 1) {
                return;
            }
            for (String className : classCache) {
                // 通过反射获取对象
                // Spring IOC中会判断jdk和cglib代理，此处直接创建
                Class<?> aClass = Class.forName(className);
                if (aClass.isAnnotationPresent(XfcController.class)) {
                    String beanId = lowerFirstChar(aClass.getSimpleName());
                    beanMap.put(beanId, aClass.newInstance());
                    continue;
                } else if (aClass.isAnnotationPresent(XfcService.class)) {
                    XfcService xfcService = aClass.getAnnotation(XfcService.class);
                    String beanId = xfcService.value();
                    if (!"".equals(beanId.trim())) {
                        beanMap.put(beanId, aClass.newInstance());
                    }
                    Class<?>[] interfaces = aClass.getInterfaces();

                    // 如果这个类实现了接口，则默认用接口的名字作为bena的名字
                    for (Class<?> anInterface : interfaces) {
                        String name = anInterface.getSimpleName();
                        beanMap.put(lowerFirstChar(name), aClass.newInstance());
                    }
                } else {
                    continue;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将首字母转为小写
     *
     * @param name
     * @return
     */
    private String lowerFirstChar(String name) {
        if (Character.isLowerCase(name.charAt(0))) {
            return name;
        } else {
//            return (new StringBuilder()).append(Character.toLowerCase(name.charAt(0))).append(name.substring(1)).toString();
            char[] chars = name.toCharArray();
            chars[0] += 32;
            return String.valueOf(chars);

        }
    }

    /**
     * 注入逻辑
     */
    private void populate() {
        if (beanMap.size() < 1) {
            return;
        }

        for (Map.Entry<String, Object> entry : beanMap.entrySet()) {
            // 获取对应的字段
            Field[] declaredFields = entry.getValue().getClass().getDeclaredFields();

            for (Field field : declaredFields) {
                // 判断有无@XfcAutowired注解
                if (field.isAnnotationPresent(XfcAutowired.class)) {
                    // 获取注入的名字
                    XfcAutowired annotation = field.getAnnotation(XfcAutowired.class);
                    String value = annotation.value();
                    field.setAccessible(true);
                    String beanId = value.trim();
                    if ("".equals(beanId)) {
                        // 如果是空的。默认注入字段
                        beanId = field.getType().getName();
                    }
                    try {
                        field.set(entry.getValue(), beanMap.get(beanId));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        continue;
                    }

                }

            }

        }


    }
}
