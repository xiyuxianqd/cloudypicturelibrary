package com.xiyuxian.picturecloudy.domain.space.service.impl;

import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiyuxian.picturecloudy.domain.space.entity.Space;
import com.xiyuxian.picturecloudy.domain.space.respository.SpaceRepository;
import com.xiyuxian.picturecloudy.domain.space.service.SpaceDomainService;
import com.xiyuxian.picturecloudy.domain.space.valuobject.SpaceLevelEnum;
import com.xiyuxian.picturecloudy.domain.user.entity.User;
import com.xiyuxian.picturecloudy.infrastructure.exception.BusinessException;
import com.xiyuxian.picturecloudy.infrastructure.exception.ErrorCode;
import com.xiyuxian.picturecloudy.infrastructure.mapper.SpaceMapper;
import com.xiyuxian.picturecloudy.interfaces.dto.space.SpaceQueryRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author 兮予仙
* @description 针对表【space(空间)】的数据库操作Service实现
* @createDate 2025-02-21 10:05:38
*/
@Service
public class SpaceDomainServiceImpl extends ServiceImpl<SpaceMapper, Space>
    implements SpaceDomainService {

    @Resource
    private SpaceRepository spaceRepository;

    @Override
    public QueryWrapper<Space> getQueryWrapper(SpaceQueryRequest spaceQueryRequest) {
        QueryWrapper<Space> queryWrapper = new QueryWrapper<>();
        if (spaceQueryRequest == null) {
            return queryWrapper;
        }
        // 从对象中取值
        Long id = spaceQueryRequest.getId();
        Long userId = spaceQueryRequest.getUserId();
        String spaceName = spaceQueryRequest.getSpaceName();
        Integer spaceLevel = spaceQueryRequest.getSpaceLevel();
        Integer spaceType = spaceQueryRequest.getSpaceType();
        String sortField = spaceQueryRequest.getSortField();
        String sortOrder = spaceQueryRequest.getSortOrder();
        // 拼接查询条件
        queryWrapper.eq(ObjUtil.isNotEmpty(id), "id", id);
        queryWrapper.eq(ObjUtil.isNotEmpty(userId), "userId", userId);
        queryWrapper.like(StrUtil.isNotBlank(spaceName), "spaceName", spaceName);
        queryWrapper.eq(ObjUtil.isNotEmpty(spaceLevel), "spaceLevel", spaceLevel);
        queryWrapper.eq(ObjUtil.isNotEmpty(spaceType), "spaceType", spaceType);
        // 排序
        queryWrapper.orderBy(StrUtil.isNotEmpty(sortField), sortOrder.equals("ascend"), sortField);
        return queryWrapper;
    }

    @Override
    public void fillSpaceBySpaceLevel(Space space) {
        SpaceLevelEnum spaceLevelEnum = SpaceLevelEnum.getEnumByValue(space.getSpaceLevel());
        if (spaceLevelEnum != null) {
            long maxSize = spaceLevelEnum.getMaxSize();
            if (space.getMaxSize() == null) {
                space.setMaxSize(maxSize);
            }
            long maxCount = spaceLevelEnum.getMaxCount();
            if (space.getMaxCount() == null) {
                space.setMaxCount(maxCount);
            }
        }
    }

    @Override
    public void checkSpaceAuth(User loginUser, Space space) {
        // 仅本人或管理员可编辑
        if (!space.getUserId().equals(loginUser.getId()) && !loginUser.isAdmin()) {
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }
    }
}




