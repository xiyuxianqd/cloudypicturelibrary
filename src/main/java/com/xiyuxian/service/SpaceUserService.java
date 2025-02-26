package com.xiyuxian.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiyuxian.domain.SpaceUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiyuxian.spaceuser.SpaceUserAddRequest;
import com.xiyuxian.spaceuser.SpaceUserQueryRequest;
import com.xiyuxian.vo.SpaceUserVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author 兮予仙
* @description 针对表【space_user(空间用户关联)】的数据库操作Service
* @createDate 2025-02-25 10:19:58
*/
public interface SpaceUserService extends IService<SpaceUser> {

    /**
     * 创建空间成员
     *
     * @param spaceUserAddRequest
     * @return
     */
    //添加空间成员：
    long addSpaceUser(SpaceUserAddRequest spaceUserAddRequest);


    //校验空间成员对象
    // 增加 add 参数用来区分是创建数据时校验还是编辑时校验
    // 判断条件是不一样的。比如创建成员时要检查用户是否存在。
    /**
     * 校验空间成员
     *
     * @param spaceUser
     * @param add       是否为创建时检验
     */
    void validSpaceUser(SpaceUser spaceUser, boolean add);


    /**
     * 获取查询对象
     *
     * @param spaceUserQueryRequest
     * @return
     */
    //将查询请求对象转换为 MyBatis-Plus 的查询封装对象：
    QueryWrapper<SpaceUser> getQueryWrapper(SpaceUserQueryRequest spaceUserQueryRequest);

    /**
     * 获取空间成员包装类（单条）
     *
     * @param //spaceUser
     * @param //request
     * @return
     */
    //获取空间成员封装类
    SpaceUserVO getSpaceUserVO(SpaceUser spaceUser, HttpServletRequest request);

    /**
     * 获取空间成员包装类（列表）
     *
     * @param spaceUserList
     * @return
     */
    //查询封装类列表
    List<SpaceUserVO> getSpaceUserVOList(List<SpaceUser> spaceUserList);


}
