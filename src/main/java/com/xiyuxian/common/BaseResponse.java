package com.xiyuxian.common;

import com.xiyuxian.exception.ErrorCode;
import lombok.Data;

import java.io.Serializable;

@Data
public class BaseResponse<T> implements Serializable {

    private int code;
    private String msg;
    private T data;
    public BaseResponse(int code,T data,String msg) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
//    public BaseResponse(int code, String msg) {
//        this.code = code;
//        this.msg = msg;
//    }

    public BaseResponse(int code,T data) {
        this(code,data,"");
    }

    public BaseResponse(ErrorCode errorCode) {
        this(errorCode.getCode(),null,errorCode.getMsg());


    }
}
