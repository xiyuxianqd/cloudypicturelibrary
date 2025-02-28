package com.xiyuxian.picturecloudy.domain.space.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiyuxian.picturecloudy.domain.space.entity.Space;
import com.xiyuxian.picturecloudy.domain.user.entity.User;
import com.xiyuxian.picturecloudy.interfaces.dto.space.SpaceQueryRequest;

/**
* @author 兮予仙
* @description 针对表【space(空间)】的数据库操作Service
* @createDate 2025-02-21 10:05:38
*/
public interface SpaceDomainService extends IService<Space> {

    /**
     * 获取查询对象
     *
     * @param spaceQueryRequest
     * @return
     */
    QueryWrapper<Space> getQueryWrapper(SpaceQueryRequest spaceQueryRequest);

    /**
     * 根据空间级别填充空间对象
     *
     * @param space
     */
    void fillSpaceBySpaceLevel(Space space);

    /**
     * 校验空间权限
     *
     * @param loginUser
     * @param space
     */
    void checkSpaceAuth(User loginUser, Space space);

}
