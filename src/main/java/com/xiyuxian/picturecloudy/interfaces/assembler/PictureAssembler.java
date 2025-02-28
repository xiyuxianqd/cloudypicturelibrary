package com.xiyuxian.picturecloudy.interfaces.assembler;

import cn.hutool.json.JSONUtil;
import com.xiyuxian.picturecloudy.domain.picture.entity.Picture;
import com.xiyuxian.picturecloudy.interfaces.dto.picture.PictureEditRequest;
import com.xiyuxian.picturecloudy.interfaces.dto.picture.PictureUpdateRequest;
import org.springframework.beans.BeanUtils;

public class PictureAssembler {

    public static Picture toPictureEntity(PictureEditRequest request) {
        Picture picture = new Picture();
        BeanUtils.copyProperties(request, picture);
        // 注意将 list 转为 string
        picture.setTags(JSONUtil.toJsonStr(request.getTags()));
        return picture;
    }

    public static Picture toPictureEntity(PictureUpdateRequest request) {
        Picture picture = new Picture();
        BeanUtils.copyProperties(request, picture);
        // 注意将 list 转为 string
        picture.setTags(JSONUtil.toJsonStr(request.getTags()));
        return picture;
    }
}

