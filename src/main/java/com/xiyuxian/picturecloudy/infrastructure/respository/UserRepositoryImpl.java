package com.xiyuxian.picturecloudy.infrastructure.respository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiyuxian.picturecloudy.domain.user.entity.User;
import com.xiyuxian.picturecloudy.domain.user.respository.UserRepository;
import com.xiyuxian.picturecloudy.infrastructure.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserRepositoryImpl extends ServiceImpl<UserMapper, User> implements UserRepository {
}