package com.xiyuxian.picturecloudy.infrastructure.respository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiyuxian.picturecloudy.domain.space.entity.Space;
import com.xiyuxian.picturecloudy.domain.space.respository.SpaceRepository;
import com.xiyuxian.picturecloudy.infrastructure.mapper.SpaceMapper;
import org.springframework.stereotype.Service;

@Service
public class SpaceRepositoryImpl extends ServiceImpl<SpaceMapper, Space> implements SpaceRepository {


}