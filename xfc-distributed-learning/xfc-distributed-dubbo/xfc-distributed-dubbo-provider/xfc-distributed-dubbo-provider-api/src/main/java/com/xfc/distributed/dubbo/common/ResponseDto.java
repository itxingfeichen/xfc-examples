package com.xfc.distributed.dubbo.common;

import java.io.Serializable;

/**
 * @author : chenxingfei
 * @date: 2019-05-04  21:08
 * @description: 请求参数传输对象
 */
public class ResponseDto implements Serializable {

    private Long errorCode;

    private String errorMsg;

    private Object object;

    public Long getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Long errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                ", object=" + object +
                '}';
    }
}
