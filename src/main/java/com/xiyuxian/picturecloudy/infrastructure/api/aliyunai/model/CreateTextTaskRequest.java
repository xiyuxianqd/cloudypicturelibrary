package com.xiyuxian.picturecloudy.infrastructure.api.aliyunai.model;


import cn.hutool.core.annotation.Alias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTextTaskRequest  implements Serializable {

    /**
     * 模型，例如 "image-out-painting"
     */
    private String model;

    /**
     * 输入文本提示
     */
    private List<Message> messages;

//    /**
//     * 输入信息
//     */
//    private Input input;
//    @Data
//    public static class Input {
//        /**
//         * 文本输入
//         */
////        @Alias("image_url")
//        private String inputtext;
//    }

    /**
     * 其他参数，例如最大长度
     */
    @JsonProperty("max_tokens")
    private Integer maxTokens;

}
