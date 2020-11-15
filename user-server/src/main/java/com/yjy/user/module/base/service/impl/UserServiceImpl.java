package com.yjy.user.module.base.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yjy.common.enums.CommonStatus;
import com.yjy.user.dto.UserLoginRequest;
import com.yjy.user.dto.UserRegisterRequest;
import com.yjy.user.module.base.entity.User;
import com.yjy.user.module.base.mapper.UserMapper;
import com.yjy.user.module.base.service.IUserService;
import com.yjy.common.utils.ResultUtil;
import com.yjy.common.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * 
 */
@SuppressWarnings({"SpringJavaInjectionPointsAutowiringInspection", "SpringJavaAutowiredFieldsWarningInspection"})
@Service

public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户注册
     *
     * @param userRegisterRequest 用户实体
     * @return Object
     */
    @Override
    public Result<Object> register(UserRegisterRequest userRegisterRequest) {

        //根据业务，验证数据合法性
        User exist;
        exist = userMapper.selectByUsername(userRegisterRequest.getUsername());
        if (ObjectUtil.isNotNull(exist)) {
            return new ResultUtil<>().setErrorMsg(HttpStatus.INTERNAL_SERVER_ERROR.value(), "用户名已被注册");
        }
        exist = userMapper.selectByMobile(userRegisterRequest.getMobile());
        if (ObjectUtil.isNotNull(exist)) {
            return new ResultUtil<>().setErrorMsg(HttpStatus.INTERNAL_SERVER_ERROR.value(), "手机号已被注册");
        }


        User user = new User();
        user.setMobile(userRegisterRequest.getMobile());
        user.setEmail(userRegisterRequest.getEmail());
        user.setUsername(userRegisterRequest.getUsername());
        //密码加密
        user.setPassword(this.encodePassword(userRegisterRequest.getPassword()));
        if (save(user)) {
            return new ResultUtil<>().setData(null);
        } else {
            return new ResultUtil<>().setErrorMsg("注册失败");
        }
    }

    @Override
    public Result<Object> login(UserLoginRequest userLoginRequest) {

        //查询用户存不存在
        User user = userMapper.selectByUsernameOrMobile(userLoginRequest.getAccount());
        if (ObjectUtil.isNull(user)) {
            return new ResultUtil<>().setErrorMsg(HttpStatus.INTERNAL_SERVER_ERROR.value(), "用户名不正确");
        }

        //用户禁用
        if (user.getStatus() == CommonStatus.STATUS_DISABLED.getStatus()) {
            return new ResultUtil<>().setErrorMsg(HttpStatus.INTERNAL_SERVER_ERROR.value(), "用户被禁用");
        }

        //用户删除
        if (user.getStatus() == CommonStatus.STATUS_DELETED.getStatus()) {
            return new ResultUtil<>().setErrorMsg(HttpStatus.INTERNAL_SERVER_ERROR.value(), "用户已被删除");
        }

        //校验密码
        if (!this.encodePassword(userLoginRequest.getPassword()).equals(user.getPassword())) {
            return new ResultUtil<>().setErrorMsg(HttpStatus.INTERNAL_SERVER_ERROR.value(), "密码错误");
        }

        //转domain到dto
        User userModel = new User();
        userModel.setId(user.getId());
        userModel.setMobile(user.getMobile());
        userModel.setEmail(user.getEmail());
        userModel.setUsername(user.getUsername());
        userModel.setCreatedAt(user.getCreatedAt());
        userModel.setUpdatedAt(user.getUpdatedAt());
        userModel.setStatus(user.getStatus());

        return new ResultUtil<>().setData(userModel);
    }

    /**
     * 获取用户信息
     * @param userId 用户id
     * @return 用户数据
     */
    @Override
    public User getUser(String userId) {
        User user = getById(userId);
        User userModel = new User();
        userModel.setId(user.getId());
        userModel.setMobile(user.getMobile());
        userModel.setEmail(user.getEmail());
        userModel.setUsername(user.getUsername());
        userModel.setStatus(user.getStatus());
        userModel.setCreatedAt(user.getCreatedAt());
        userModel.setUpdatedAt(user.getUpdatedAt());
        return userModel;
    }

    /**
     * 加密登录密码
     * @param password 登录密码名文
     * @return String
     */
    private String encodePassword(String password) {
        return SecureUtil.md5(SecureUtil.md5(password));
    }
}
