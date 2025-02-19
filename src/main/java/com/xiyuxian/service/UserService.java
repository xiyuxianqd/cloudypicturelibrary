package com.xiyuxian.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiyuxian.vo.LoginUserVO;
import com.xiyuxian.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiyuxian.user.UserQueryRequest;
import com.xiyuxian.vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author 兮予仙
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2025-02-17 16:36:11
*/
public interface UserService extends IService<User> {

    /**
     * 用户注册
     *
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param checkPassword 校验密码
     * @return 新用户 id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);

    String getEncryptPassword(String userPassword);

    /**
     * 用户登录
     *
     * @param userAccount  用户账户
     * @param userPassword 用户密码
     * @param request
     * @return 脱敏后的用户信息
     */
    LoginUserVO userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 获取脱敏的已登录用户信息
     *
     * @return
     */
    LoginUserVO getLoginUserVO(User user);

    /**
     * 获取当前登录用户
     *
     * @param request
     * @return
     */
    User getLoginUser(HttpServletRequest request);



    /**
     * 用户注销
     *
     * @param request
     * @return
     */
    boolean userLogout(HttpServletRequest request);

    public UserVO getUserVO(User user);

    public List<UserVO> getUserVOList(List<User> userList);


    public QueryWrapper<User> getQueryWrapper(UserQueryRequest userQueryRequest);

    /**
     * 是否为管理员
     *
     * @param user
     * @return
     */
    boolean isAdmin(User user);


}
