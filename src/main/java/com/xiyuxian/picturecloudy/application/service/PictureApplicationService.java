package com.xiyuxian.picturecloudy.application.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiyuxian.picturecloudy.domain.picture.entity.Picture;
import com.xiyuxian.picturecloudy.domain.user.entity.User;
import com.xiyuxian.picturecloudy.infrastructure.api.aliyunai.model.CreateOutPaintingTaskResponse;
import com.xiyuxian.picturecloudy.infrastructure.api.aliyunai.model.CreateTextTaskRequest;
import com.xiyuxian.picturecloudy.infrastructure.api.aliyunai.model.CreateTextTaskResponse;
import com.xiyuxian.picturecloudy.interfaces.dto.picture.*;
import com.xiyuxian.picturecloudy.interfaces.vo.picture.PictureVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 兮予仙
 * @description 针对表【picture(图片)】的数据库操作Service
 * @createDate 2025-02-19 11:19:42
 */
public interface PictureApplicationService extends IService<Picture> {

    /**
     * 校验图片
     *
     * @param picture
     * 11
     */
    void validPicture(Picture picture);

    /**
     * 上传图片
     *
     * @param //multipartFile=>改成object inputsource保证string和multipartfile都可以
     * @param pictureUploadRequest
     * @param loginUser
     * @return
     * 11
     */
    PictureVO uploadPicture(Object inputSource,
                            PictureUploadRequest pictureUploadRequest,
                            User loginUser);

    /**
     * 获取查询对象
     *
     * @param pictureQueryRequest
     * @return
     */
    QueryWrapper<Picture> getQueryWrapper(PictureQueryRequest pictureQueryRequest);

    /**
     * 获取图片包装类（单条）
     *
     * @param picture
     * @param request
     * @return
     */
    PictureVO getPictureVO(Picture picture, HttpServletRequest request);

    /**
     * 获取图片包装类（分页）
     *
     * @param picturePage
     * @param request
     * @return
     */
    Page<PictureVO> getPictureVOPage(Page<Picture> picturePage, HttpServletRequest request);



    /**
     * 图片审核
     *
     * @param pictureReviewRequest
     * @param loginUser
     */
    void doPictureReview(PictureReviewRequest pictureReviewRequest, User loginUser);

    /**
     * 填充审核参数
     *
     * @param picture
     * @param loginUser
     */
    void fillReviewParams(Picture picture, User loginUser);


    /**
     * 编辑图片
     *
     * @param picture //改了
     * @param loginUser
     */
   // void editPicture(PictureEditRequest pictureEditRequest, User loginUser);
    void editPicture(Picture picture, User loginUser);

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
     * 11
     */
    Integer uploadPictureByBatch(
            PictureUploadByBatchRequest pictureUploadByBatchRequest,
            User loginUser
    );

    /**
     * 根据颜色搜索图片
     *
     * @param spaceId
     * @param picColor
     * @param loginUser
     * @return
     */
    List<PictureVO> searchPictureByColor(Long spaceId, String picColor, User loginUser);

    /**
     * 批量编辑图片
     *
     * @param pictureEditByBatchRequest
     * @param loginUser
     */
    void editPictureByBatch(PictureEditByBatchRequest pictureEditByBatchRequest, User loginUser);

    /**
     * 清理图片文件
     *11
     * @param oldPicture
     */
    void clearPictureFile(Picture oldPicture);

    /**
     * 删除图片
     *
     * @param pictureId
     * @param loginUser
     */
    void deletePicture(long pictureId, User loginUser);



    /**
     * 创建扩图任务
     *
     * @param createPictureOutPaintingTaskRequest
     * @param loginUser
     */
    CreateOutPaintingTaskResponse createPictureOutPaintingTask(CreatePictureOutPaintingTaskRequest createPictureOutPaintingTaskRequest, User loginUser);

    /**
     * 创建文本任务
     *
     * @param createTextTaskRequest
     * @param loginUser
     */
    CreateTextTaskResponse createTextTask(CreateTextTaskRequest Request, User loginUser);

}
