package com.github.xfc.framework.servlet;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : chenxingfei
 * @date: 2019-04-20  17:14
 * @description: 视图模型封装
 */
public class XfcModelAndView {

    private Object view;

    private Map<String, Object> model = new HashMap<String, Object>();


    public XfcModelAndView(Object view) {
        this.view = view;
    }

    public Object getView() {
        return view;
    }

    public void setView(Object view) {
        this.view = view;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }
}
