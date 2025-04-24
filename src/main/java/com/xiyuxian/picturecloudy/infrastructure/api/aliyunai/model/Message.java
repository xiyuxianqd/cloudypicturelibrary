package com.xiyuxian.picturecloudy.infrastructure.api.aliyunai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public  class Message implements Serializable {

    /** user / assistant / system / tool */
    private String role; //user

    /** 文字内容（多模态就换成 List<Object>） */
    private String content;
}