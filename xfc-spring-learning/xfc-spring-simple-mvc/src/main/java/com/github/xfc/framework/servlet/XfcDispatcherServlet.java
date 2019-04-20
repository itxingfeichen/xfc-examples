package com.github.xfc.framework.servlet;

import com.github.xfc.framework.context.XfcApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : chenxingfei
 * @date: 2019-04-20  16:35
 * @description: 自定义转发器
 */
public class XfcDispatcherServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        try {
            doDispatch(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 请求转发
     * @param req
     * @param resp
     * @throws Exception
     */
    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws Exception {
       Handler handler =  getHandler(req);
        if (handler == null) {
            resp.getWriter().write("404 Not Found");
        }

        HandlerAdapter adapter = getHandlerAdapter(handler);

//        adapter.handle()handl

    }

    /**
     * 获取合适的处理器
     * @param handler
     * @return
     */
    private HandlerAdapter getHandlerAdapter(Handler handler) {
        return null;
    }

    /**
     * 获取处理器
     * @param req
     * @return
     */
    private Handler getHandler(HttpServletRequest req) {
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


    }

    private void initRequestToViewNameTranslator(XfcApplicationContext context) {

    }

    private void initHandlerExceptionResolvers(XfcApplicationContext context) {

    }

    private void initHandlerAdapters(XfcApplicationContext context) {

    }

    private void initHandlerMappings(XfcApplicationContext context) {

        // 找出所有有@XfcController修饰的类，并解析相关注解
        // 找出加了@XfcRequestMapping注解的方法，其他方法


    }

    private void initThemeResolver(XfcApplicationContext context) {

    }

    private void initLocaleResolver(XfcApplicationContext context) {

    }

    private void initMultipartResolver(XfcApplicationContext context) {

    }


    private class Handler{


    }
}
