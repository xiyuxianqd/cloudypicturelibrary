package com.xiyuxian.picturecloudy.infrastructure.api.aliyunai;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.ContentType;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.xiyuxian.picturecloudy.infrastructure.api.aliyunai.model.*;
import com.xiyuxian.picturecloudy.infrastructure.exception.BusinessException;
import com.xiyuxian.picturecloudy.infrastructure.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class TextTestApi {
    // 读取配置文件
    @Value("${aliYunAi.apiKey}")
    private String apiKey;

    // 创建任务地址
    public static final String TEXT_GENERATION_URL = "https://dashscope.aliyuncs.com/compatible-mode/v1/chat/completions";

    // 查询任务状态
    //public static final String GET_OUT_PAINTING_TASK_URL = "https://dashscope.aliyuncs.com/compatible-mode/v1";

    /*创建任务
    * */
    public CreateTextTaskResponse createTextTask(CreateTextTaskRequest request) {
        // 构造消息列表
        List<Message> messages = new ArrayList<>();


//        if (request == null || StrUtil.isBlank(request.getMessages())) {
//            throw new BusinessException(ErrorCode.OPERATION_ERROR, "文本提示不能为空");
//        }

        HttpRequest httpRequest = HttpRequest.post(TEXT_GENERATION_URL)
                .header(Header.AUTHORIZATION, "Bearer " + apiKey)
                .header(Header.CONTENT_TYPE, ContentType.JSON.getValue())
                .body(JSONUtil.toJsonStr(request));
        try (HttpResponse httpResponse = httpRequest.execute()) {
            if (!httpResponse.isOk()) {
                log.error("请求异常：{}", httpResponse.body());
                throw new BusinessException(ErrorCode.OPERATION_ERROR, "文本生成失败");
            }

            // 解析响应
            CreateTextTaskResponse response = JSONUtil.toBean(httpResponse.body(), CreateTextTaskResponse.class);
            if (response.getChoices() == null || response.getChoices().length == 0) {
                throw new BusinessException(ErrorCode.OPERATION_ERROR, "生成内容为空");
            }

            return response;
        }
          }

//        /**
//         * 查询创建的任务
//         *
//         * @param taskId
//         * @return
//         */
//        public GetTextTaskResponse getTextTaskResponse(String taskId) {
//            if (StrUtil.isBlank(taskId)) {
//                throw new BusinessException(ErrorCode.OPERATION_ERROR, "任务 id 不能为空");
//            }
//            try (HttpResponse httpResponse = HttpRequest.get(String.format(GET_OUT_PAINTING_TASK_URL, taskId))
//                    .header(Header.AUTHORIZATION, "Bearer " + apiKey)
//                    .execute()) {
//                if (!httpResponse.isOk()) {
//                    throw new BusinessException(ErrorCode.OPERATION_ERROR, "获取任务失败");
//                }
//                return JSONUtil.toBean(httpResponse.body(),  GetTextTaskResponse.class);
//            }
//        }
}



