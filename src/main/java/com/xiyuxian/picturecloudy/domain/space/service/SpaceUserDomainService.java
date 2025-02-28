package com.xiyuxian.picturecloudy.domain.space.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiyuxian.picturecloudy.domain.space.entity.SpaceUser;
import com.xiyuxian.picturecloudy.interfaces.dto.spaceuser.SpaceUserQueryRequest;

public interface SpaceUserDomainService {
    /**
     * 获取查询对象
     *
     * @param spaceUserQueryRequest
     * @return
     */
    QueryWrapper<SpaceUser> getQueryWrapper(SpaceUserQueryRequest spaceUserQueryRequest);

}
