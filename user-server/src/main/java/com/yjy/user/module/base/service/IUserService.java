package com.yjy.user.module.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yjy.common.vo.Result;
import com.yjy.user.module.base.controller.request.UserLoginRequest;
import com.yjy.user.module.base.controller.request.UserRegisterRequest;
import com.yjy.user.module.base.entity.User;

/**
 * 
 * 用户接口类
 */
public interface IUserService extends IService<User> {

    /**
     * 用户注册
     * @param userRegisterRequest 注册实体
     * @return User
     */
    Result<Object> register(UserRegisterRequest userRegisterRequest);

    /**
     * 用户登录
     * @param userLoginRequest 登录实体
     * @return Object
     */
    Result<Object> login(UserLoginRequest userLoginRequest);

    /**
     * 查询一个用户
     * @param userId 用户ID
     * @return User
     */
    User getUser(String userId);
}
