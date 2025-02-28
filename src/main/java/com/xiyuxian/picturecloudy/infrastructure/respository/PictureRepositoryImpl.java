package com.xiyuxian.picturecloudy.infrastructure.respository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiyuxian.picturecloudy.domain.picture.entity.Picture;
import com.xiyuxian.picturecloudy.domain.picture.respository.PictureRepository;
import com.xiyuxian.picturecloudy.infrastructure.mapper.PictureMapper;
import org.springframework.stereotype.Service;

@Service
public class PictureRepositoryImpl extends ServiceImpl<PictureMapper, Picture> implements PictureRepository {
}