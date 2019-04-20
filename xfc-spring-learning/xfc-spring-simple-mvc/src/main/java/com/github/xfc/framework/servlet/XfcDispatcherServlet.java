package com.github.xfc.framework.servlet;

import com.github.xfc.framework.annotation.XfcController;
import com.github.xfc.framework.annotation.XfcRequestMapping;
import com.github.xfc.framework.annotation.XfcRequestParam;
import com.github.xfc.framework.context.XfcApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : chenxingfei
 * @date: 2019-04-20  16:35
 * @description: 自定义转发器
 */
public class XfcDispatcherServlet extends HttpServlet {

    private List<XfcHandler> handlerMapping = new ArrayList<XfcHandler>(16);

    private Map<XfcHandler, HandlerAdapter> adapterMapping = new HashMap<XfcHandler, HandlerAdapter>(16);

    private List<XfcViewResolver> resolvers = new ArrayList<XfcViewResolver>();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doDispatch(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 请求转发
     *
     * @param req
     * @param resp
     * @throws Exception
     */
    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        XfcHandler handler = getHandler(req);
        if (handler == null) {
            resp.getWriter().write("404 Not Found");
        }

        HandlerAdapter ha = getHandlerAdapter(handler);

        XfcModelAndView mv = ha.handle(req, resp, handler);

        // 解析视图
        applyDefaultViewName(resp, mv);

    }

    private void applyDefaultViewName(HttpServletResponse resp, XfcModelAndView mv) {
        if (mv == null || resolvers.isEmpty()) {
            return;
        }

        for (XfcViewResolver resolver : resolvers) {
            // 如果没有找到对应的视图，继续匹配
            if (!mv.getView().toString().equals(resolver.getViewName())) {
                return;
            }
            String result = resolver.parse(mv);

            if (result != null) {
                try {
                    resp.getWriter().write(result);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 获取合适的处理器
     *
     * @param handler
     * @return
     */
    private HandlerAdapter getHandlerAdapter(XfcHandler handler) {
        return adapterMapping.get(handler);
    }

    /**
     * 获取处理器
     *
     * @param req
     * @return
     */
    private XfcHandler getHandler(HttpServletRequest req) {
        if (handlerMapping.isEmpty()) {
            return null;
        }
        String contextPath = req.getContextPath();
        String requestURI = req.getRequestURI();
        String url = requestURI.replace(contextPath, "").replaceAll("/", "/");


        for (XfcHandler handler : handlerMapping) {
            Pattern pattern = handler.getPattern();
            Matcher matcher = pattern.matcher(url);
            if (!matcher.matches()) {
                continue;
            }
            return handler;

        }
        return null;
    }

    @Override
    public void init(ServletConfig config) throws ServletException {

        // 启动ioc容器
        XfcApplicationContext context = new XfcApplicationContext(config.getInitParameter("contextConfigLocation"));
        // 请求解析（含文件流的请求）
        initMultipartResolver(context);
        // 国际化
        initLocaleResolver(context);
        // 解析主题view层
        initThemeResolver(context);
        // 异常视图解析器
        initHandlerExceptionResolvers(context);
        // 视图转发（根据视图名字匹配到一个具体模版）
        initRequestToViewNameTranslator(context);
        // 解析模版中的内容
        initViewResolvers(context);
        // todo ?? cxf
        initFlashMapManager(context);


        // 解析url和Method的关联关系
        initHandlerMappings(context);
        // 适配器（匹配）
        initHandlerAdapters(context);
    }

    private void initFlashMapManager(XfcApplicationContext context) {

    }

    private void initViewResolvers(XfcApplicationContext context) {

        String rootTemplate = context.getConfig().getProperty("rootTemplate");
        URL resource = this.getClass().getClassLoader().getResource(rootTemplate);

        File file = new File(resource.getFile());

        for (File fileNew : file.listFiles()) {
            resolvers.add(new XfcViewResolver(fileNew.getName(), fileNew));
        }
    }

    private void initRequestToViewNameTranslator(XfcApplicationContext context) {

    }

    private void initHandlerExceptionResolvers(XfcApplicationContext context) {

    }

    /**
     * 动态匹配参数，并且可以动态赋值
     *
     * @param context
     */
    private void initHandlerAdapters(XfcApplicationContext context) {

        if (handlerMapping.isEmpty()) {
            return;
        }

        // 声明适配器存储的数据内容


        // 声明一个map，用户保存参数类型对应的参数顺序
        Map<String, Integer> params = new HashMap<String, Integer>(16);
        // 处理参数
        for (XfcHandler handler : handlerMapping) {
            Method method = handler.getMethod();
            Class<?>[] parameterTypes = method.getParameterTypes();

            for (int i = 0; i < parameterTypes.length; i++) {
                Class<?> parameterType = parameterTypes[i];

                // 适配参数，适配request，和response
                if (parameterType == HttpServletResponse.class || parameterType == HttpServletRequest.class) {
                    params.put(parameterType.getName(), i);
                }

                // 适配带注解的参数,二维数组，代表一个参数可能会有多个注解
                Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                for (Annotation[] parameterAnnotation : parameterAnnotations) {
                    for (Annotation annotation : parameterAnnotation) {
                        if (annotation instanceof XfcRequestParam) {
                            String paramName = ((XfcRequestParam) annotation).value();
                            params.put(paramName, i);
                        }
                    }
                }

            }
            adapterMapping.put(handler, new HandlerAdapter(params));

        }


    }

    private void initHandlerMappings(XfcApplicationContext context) {

        // 找出所有有@XfcController修饰的类，并解析相关注解
        // 找出加了@XfcRequestMapping注解的方法，其他方法

        Map<String, Object> allBeans = context.getAllBeans();
        if (allBeans.isEmpty()) {
            return;
        }

        for (Map.Entry<String, Object> entry : allBeans.entrySet()) {
            Class<? extends Map.Entry> aClass = entry.getClass();

            //  处理含@XfcController注解的类
            if (!aClass.isAnnotationPresent(XfcController.class)) {
                continue;
            }
            String url = "";
            // 如果类上含@XfcController注解
            XfcRequestMapping annotation = aClass.getAnnotation(XfcRequestMapping.class);
            if (annotation != null) {
                url = annotation.value();
            }
            // 解析方法上上的注解
            Method[] methods = aClass.getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(XfcRequestMapping.class)) {
                    XfcRequestMapping methodAnnotation = method.getAnnotation(XfcRequestMapping.class);
                    if (methodAnnotation != null) {
                        // 组装请求路径，并且把连续的多个斜杠替换为一个斜杠
                        String regx = (url + methodAnnotation.value()).replaceAll("/+", "/");
                        Pattern pattern = Pattern.compile(regx);
                        handlerMapping.add(new XfcHandler(entry.getValue(), method, pattern));
                    }

                }
            }

        }

    }

    private void initThemeResolver(XfcApplicationContext context) {

    }

    private void initLocaleResolver(XfcApplicationContext context) {

    }

    private void initMultipartResolver(XfcApplicationContext context) {

    }


}
