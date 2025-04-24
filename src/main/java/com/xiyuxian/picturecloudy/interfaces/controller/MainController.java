package com.xiyuxian.picturecloudy.interfaces.controller;

import com.xiyuxian.picturecloudy.application.service.PictureApplicationService;
import com.xiyuxian.picturecloudy.application.service.UserApplicationService;
import com.xiyuxian.picturecloudy.domain.picture.service.PictureDomainService;
import com.xiyuxian.picturecloudy.domain.user.entity.User;
import com.xiyuxian.picturecloudy.domain.user.service.UserDomainService;
import com.xiyuxian.picturecloudy.infrastructure.api.aliyunai.model.CreateOutPaintingTaskResponse;
import com.xiyuxian.picturecloudy.infrastructure.api.aliyunai.model.CreateTextTaskRequest;
import com.xiyuxian.picturecloudy.infrastructure.api.aliyunai.model.CreateTextTaskResponse;
import com.xiyuxian.picturecloudy.infrastructure.common.BaseResponse;
import com.xiyuxian.picturecloudy.infrastructure.common.ResultUtils;
import com.xiyuxian.picturecloudy.infrastructure.exception.BusinessException;
import com.xiyuxian.picturecloudy.infrastructure.exception.ErrorCode;
import com.xiyuxian.picturecloudy.interfaces.dto.picture.CreateOutTextTaskRequest;
import com.xiyuxian.picturecloudy.interfaces.dto.picture.CreatePictureOutPaintingTaskRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    UserDomainService userDomainService;
    @Resource
    UserApplicationService userApplicationService;
    @Resource
    PictureApplicationService pictureApplicationService;
    /**
     * 健康检查
     */
    @GetMapping("/health")
    public BaseResponse<String> health() {
        return ResultUtils.success("ok");
    }

//    @GetMapping("/TESTinterface")
//    public BaseResponse<CreateTextTaskResponse> createPictureOutPaintingTask(
//                @RequestBody CreateTextTaskRequest Request1,
//                HttpServletRequest request) {
////
////        if (Request1.getInput() == null || Request1.getInput().getInputtext().isEmpty()) {
////                throw new BusinessException(ErrorCode.PARAMS_ERROR,"文本内容不能为空");
////            }
//
//        return pictureApplicationService.createTextTaskTask(Request1,loginUser);
//    }
@PostMapping("/text/task") // 修改为POST请求，并使用更合适的路径
public BaseResponse<CreateTextTaskResponse> createTextTask(
        @RequestBody CreateTextTaskRequest request,
        HttpServletRequest httpRequest) {
    // 基本参数验证
//    if (request.getInput() == null || request.getInput().getInputtext() == null || request.getInput().getInputtext().isEmpty()) {
//        throw new BusinessException(ErrorCode.PARAMS_ERROR, "文本内容不能为空");
//    }

    // 获取登录用户
    User loginUser = userApplicationService.getLoginUser(httpRequest);

    // 调用应用服务
    CreateTextTaskResponse response = pictureApplicationService.createTextTask(request, loginUser);

    return ResultUtils.success(response);
}


}
