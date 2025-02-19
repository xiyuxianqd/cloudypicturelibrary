package com.xiyuxian.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiyuxian.domain.Picture;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiyuxian.domain.PictureUploadRequest;
import com.xiyuxian.domain.User;
import com.xiyuxian.picture.PictureQueryRequest;
import com.xiyuxian.vo.PictureVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
* @author 兮予仙
* @description 针对表【picture(图片)】的数据库操作Service
* @createDate 2025-02-19 11:19:42
*/
public interface PictureService extends IService<Picture> {
    /**
     * 上传图片
     *
     * @param multipartFile
     * @param pictureUploadRequest
     * @param loginUser
     * @return
     */
    PictureVO uploadPicture(MultipartFile multipartFile,
                            PictureUploadRequest pictureUploadRequest,
                            User loginUser);


    public QueryWrapper<Picture> getQueryWrapper(PictureQueryRequest pictureQueryRequest);


    public PictureVO getPictureVO(Picture picture, HttpServletRequest request);

    public Page<PictureVO> getPictureVOPage(Page<Picture> picturePage, HttpServletRequest request);

    public void validPicture(Picture picture);

}
