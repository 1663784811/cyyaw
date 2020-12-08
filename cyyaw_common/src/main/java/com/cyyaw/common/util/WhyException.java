package com.cyyaw.common.util;


import com.cyyaw.common.err.WebErrCodeEnum;

public class WhyException extends RuntimeException {

    String message;
    Integer code;

    public WhyException() {
    }

    public WhyException(WebErrCodeEnum webErrCodeEnum) {
        this.message = webErrCodeEnum.getMsg();
        this.code = webErrCodeEnum.getCode();
    }

    public WhyException(String message) {
        this.message = message;
    }

    public WhyException(String message, Integer code) {
        this.message = message;
        this.code = code;
    }


    public Integer getCode() {
        return code;
    }


    @Override
    public String getMessage() {
        String m = super.getMessage();
        if (null != message) {
            m = message;
        }
        return message;
    }
}
