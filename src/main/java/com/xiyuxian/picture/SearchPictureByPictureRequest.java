package com.xiyuxian.picture;

import lombok.Data;

import java.io.Serializable;

@Data
public class SearchPictureByPictureRequest implements Serializable {

    /*
    *
    * 图片的id
    * */
    private long pictureId;

    private static final long serialVersionUID = 1L;
}
