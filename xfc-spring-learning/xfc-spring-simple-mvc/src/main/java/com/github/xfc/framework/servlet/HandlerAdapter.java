package com.github.xfc.framework.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;

/**
 * @author : chenxingfei
 * @date: 2019-04-20  17:17
 * @description:
 */
public class HandlerAdapter {

    private Map<String, Integer> params;

    public HandlerAdapter(Map<String, Integer> params) {
        this.params = params;
    }


    public Map<String, Integer> getParams() {
        return params;
    }

    public void setParams(Map<String, Integer> params) {
        this.params = params;
    }

    public XfcModelAndView handle(HttpServletRequest req, HttpServletResponse resp, XfcHandler handler) {
        Method method = handler.getMethod();
        Class<?>[] parameterTypes = method.getParameterTypes();
        Object[] paramsArr = new Object[parameterTypes.length];

        Map<String, String[]> parameterMap = req.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            // 如果多个参数值，则匹配转换为字符串，因为request封装成的是字符数组
            // 如果请求http:localhost:8080/web/query?name=aaa&name=bbb。结果为name=aaa,bbb
            String value = Arrays.toString(entry.getValue()).replaceAll("\\[|\\]", "").replaceAll(",\\s", ",");
            Integer index = params.get(entry.getKey());
            paramsArr[index] = null;
            if (!params.containsKey(entry.getKey())) {
                continue;
            }
            paramsArr[index] = castDtaType(value, parameterTypes[index]);

        }
        // 当读封装request和response
        if (params.containsKey(HttpServletRequest.class.getName())) {
            Integer index = params.get(HttpServletRequest.class.getName());
            paramsArr[index] = req;
        }

        if (params.containsKey(HttpServletResponse.class.getName())) {
            Integer index = params.get(HttpServletResponse.class.getName());
            paramsArr[index] = resp;
        }
        try {
            Object invoke = method.invoke(handler.getObject(), paramsArr);
            Class<?> returnType = method.getReturnType();
            if (invoke != null && invoke.getClass() == XfcModelAndView.class) {
                return (XfcModelAndView) invoke;
            } else if (returnType == String.class) {
                resp.getWriter().write(invoke.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    private Object castDtaType(String value, Class<?> parameterType) {
        if (parameterType == String.class) {
            return value;
        } else if (parameterType == Integer.class) {
            return Integer.valueOf(value);
        } else if (parameterType == int.class) {
            return Integer.valueOf(value).intValue();
        }
        return value;
    }


}
