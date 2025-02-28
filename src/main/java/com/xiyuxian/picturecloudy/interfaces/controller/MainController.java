package com.xiyuxian.picturecloudy.interfaces.controller;

import com.xiyuxian.picturecloudy.domain.user.service.UserDomainService;
import com.xiyuxian.picturecloudy.infrastructure.common.BaseResponse;
import com.xiyuxian.picturecloudy.infrastructure.common.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    UserDomainService userDomainService;
    /**
     * 健康检查
     */
    @GetMapping("/health")
    public BaseResponse<String> health() {
        return ResultUtils.success("ok");
    }

}
