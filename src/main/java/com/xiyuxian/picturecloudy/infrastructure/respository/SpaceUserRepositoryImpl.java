package com.xiyuxian.picturecloudy.infrastructure.respository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiyuxian.picturecloudy.domain.space.entity.SpaceUser;
import com.xiyuxian.picturecloudy.domain.space.respository.SpaceUserRepository;
import com.xiyuxian.picturecloudy.infrastructure.mapper.SpaceUserMapper;
import org.springframework.stereotype.Service;

/**
 * 空间用户仓储实现
 */
@Service
public class SpaceUserRepositoryImpl extends ServiceImpl<SpaceUserMapper, SpaceUser> implements SpaceUserRepository {
}