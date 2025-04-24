package com.xiyuxian.picturecloudy.infrastructure.api.aliyunai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTextTaskResponse {
    private String id;          // API 返回的唯一标识
    private String object;      // 通常为 "chat.completion"
    private long created;       // 请求时间戳
    private String model;       // 使用的模型名称
    private Choice[] choices;   // 包含生成内容的数组
    private Usage usage;        // Token 使用统计（可选）

    @Data
    public static class Choice {
        private Message message; // 包含生成内容的消息对象
        // 其他字段如 index、finish_reason 等
    }

    @Data
    public static class Message {
        private String role;    // "assistant"
        private String content; // 生成的文本
    }

    @Data
    public static class Usage {
        private int prompt_tokens;
        private int completion_tokens;
        private int total_tokens;
    }
}