package com.xiyuxian.picturecloudy.interfaces.dto.picture;


import com.xiyuxian.picturecloudy.infrastructure.api.aliyunai.model.CreateOutPaintingTaskRequest;
import lombok.Data;

import java.io.Serializable;

@Data
public class CreateOutTextTaskRequest implements Serializable {
    /**
     * 图片 id
     */
    private Long TextId;


    private static final long serialVersionUID = 1L;
}
