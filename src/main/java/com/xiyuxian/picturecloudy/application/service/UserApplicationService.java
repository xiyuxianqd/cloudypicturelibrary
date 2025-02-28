package com.xiyuxian.picturecloudy.application.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiyuxian.picturecloudy.domain.user.entity.User;
import com.xiyuxian.picturecloudy.infrastructure.common.DeleteRequest;
import com.xiyuxian.picturecloudy.interfaces.dto.user.UserLoginRequest;
import com.xiyuxian.picturecloudy.interfaces.dto.user.UserQueryRequest;
import com.xiyuxian.picturecloudy.interfaces.dto.user.UserRegisterRequest;
import com.xiyuxian.picturecloudy.interfaces.vo.user.LoginUserVO;
import com.xiyuxian.picturecloudy.interfaces.vo.user.UserVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

public interface UserApplicationService {

    long userRegister(UserRegisterRequest userRegisterRequest);

    LoginUserVO userLogin(UserLoginRequest userLoginRequest, HttpServletRequest request);

    User getLoginUser(HttpServletRequest request);

    boolean userLogout(HttpServletRequest request);

    LoginUserVO getLoginUserVO(User user);

    UserVO getUserVO(User user);

    List<UserVO> getUserVOList(List<User> userList);

    QueryWrapper<User> getQueryWrapper(UserQueryRequest userQueryRequest);

    long addUser(User user);

    User getUserById(long id);

    UserVO getUserVOById(long id);

    boolean deleteUser(DeleteRequest deleteRequest);

    void updateUser(User user);

    Page<UserVO> listUserVOByPage(UserQueryRequest userQueryRequest);

    List<User> listByIds(Set<Long> userIdSet);

    String getEncryptPassword(String userPassword);



}
