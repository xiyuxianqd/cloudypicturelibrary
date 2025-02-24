package com.xiyuxian.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiyuxian.api.aliyunai.model.CreateOutPaintingTaskResponse;
import com.xiyuxian.domain.Picture;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiyuxian.picture.*;
import com.xiyuxian.domain.User;
import com.xiyuxian.vo.PictureVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author 兮予仙
* @description 针对表【picture(图片)】的数据库操作Service
* @createDate 2025-02-19 11:19:42
*/
public interface PictureService extends IService<Picture> {
    /**
     * 上传图片
     *
     * @param //multipartFile=>改成object inputsource保证string和multipartfile都可以
     * @param pictureUploadRequest
     * @param loginUser
     * @return
     */
     PictureVO uploadPicture(Object inputSource,
                            PictureUploadRequest pictureUploadRequest,
                            User loginUser);


     QueryWrapper<Picture> getQueryWrapper(PictureQueryRequest pictureQueryRequest);


     PictureVO getPictureVO(Picture picture, HttpServletRequest request);

     Page<PictureVO> getPictureVOPage(Page<Picture> picturePage, HttpServletRequest request);

     void validPicture(Picture picture);

    /**
     * 图片审核
     *
     * @param pictureReviewRequest
     * @param loginUser
     */
    void doPictureReview(PictureReviewRequest pictureReviewRequest, User loginUser);

    void fillReviewParams(Picture picture, User loginUser);

    void clearPictureFile(Picture oldPicture);

    void deletePicture(long pictureId, User loginUser);

    void editPicture(PictureEditRequest pictureEditRequest, User loginUser);
    /**
     * 校验空间图片的权限
     *
     * @param loginUser
     * @param picture
     */
    void checkPictureAuth(User loginUser, Picture picture);

    /**
     * 批量抓取和创建图片
     *
     * @param pictureUploadByBatchRequest
     * @param loginUser
     * @return 成功创建的图片数
     */
    Integer uploadPictureByBatch(
            PictureUploadByBatchRequest pictureUploadByBatchRequest,
            User loginUser
    );

     List<PictureVO> searchPictureByColor(Long spaceId, String picColor, User loginUser);

     void editPictureByBatch(PictureEditByBatchRequest pictureEditByBatchRequest, User loginUser);

    CreateOutPaintingTaskResponse createPictureOutPaintingTask(CreatePictureOutPaintingTaskRequest createPictureOutPaintingTaskRequest, User loginUser);

}
