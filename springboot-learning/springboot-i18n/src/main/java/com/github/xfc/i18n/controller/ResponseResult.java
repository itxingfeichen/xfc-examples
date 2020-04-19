package com.github.xfc.i18n.controller;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class ResponseResult<T> {
    private static ResourceBundle conf = ResourceBundle.getBundle("errorcode");
    private boolean success = true;
    private String msg = "";
    private String errMsg = "";
    private String errCode = "";
    private T data;

    @SuppressWarnings("rawtypes")
    public static ResponseResult success() {
        return new ResponseResult();
    }

    public static ResponseResult errMsg(String errMsg) {
        ResponseResult result = new ResponseResult();
        result.setSuccess(false);
        result.setErrCode("E00001");
        result.setErrMsg(errMsg);
        return result;
    }

    public static ResponseResult error(String errCode, String errMsg) {
        ResponseResult result = new ResponseResult();
        result.setErrCode(errCode);
        result.setErrMsg(errMsg);
        result.setSuccess(false);
        return result;
    }

    public static ResponseResult errCode(String errCode) {
        ResponseResult result = new ResponseResult();
        result.setErrCode(errCode);
        try {
            result.setErrMsg(conf.getString(errCode));
        } catch (Exception e) {

        }
        result.setSuccess(false);
        return result;
    }

    public static ResponseResult errCode(String errCode, Object[] args) {
        ResponseResult result = new ResponseResult();
        result.setErrCode(errCode);
        try {
            String string = new String(conf.getString(errCode).getBytes("ISO-8859-1"), "UTF8");
            result.setErrMsg(MessageFormat.format(string, args));
        } catch (Exception e) {

        }
        result.setSuccess(false);
        return result;
    }

    public static ResponseResult success(Object data) {
        ResponseResult<Object> result = new ResponseResult<>();
        result.setData(data);
        return result;
    }

    public static ResponseResult err() {
        ResponseResult<Object> result = new ResponseResult<>();
        result.setSuccess(false);
        return result;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }


}
