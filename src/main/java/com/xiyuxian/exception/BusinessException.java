package com.xiyuxian.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
    /*状态码*/
    private final int code;



    public BusinessException(int code,String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMsg());
        this.code = errorCode.getCode();
    }

    public BusinessException(ErrorCode errorCode,String message) {
        super(message);
        this.code = errorCode.getCode();
    }
}
