package com.xfc.distributed.rpc.framework.core.msg;

import java.io.Serializable;

/**
 * @author : cxf
 * @date: 2019/5/11  8:12
 * @description:
 **/
public class InvokerMsg implements Serializable {


    private String serviceName;

    private String methodName;

    private Class[] paramsList;

    private Object[] params;


    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class[] getParamsList() {
        return paramsList;
    }

    public void setParamsList(Class[] paramsList) {
        this.paramsList = paramsList;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }
}
