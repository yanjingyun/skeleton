package com.yjy.user.module.base.controller;

import com.yjy.user.authorization.annotation.CurrentUser;
import com.yjy.user.authorization.manager.TokenManager;
import com.yjy.user.dto.UserLoginRequest;
import com.yjy.user.dto.UserRegisterRequest;
import com.yjy.user.module.base.entity.User;
import com.yjy.user.module.base.service.IUserService;
import com.yjy.common.utils.ResultUtil;
import com.yjy.common.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

/**
 * 
 * 用户控制器
 */
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private TokenManager tokenManager;

    @PostMapping("/register")
    public Object register(@Valid UserRegisterRequest userRegisterRequest) {
        return userService.register(userRegisterRequest);
    }

    @PostMapping("/login")
    public Object login(@Valid UserLoginRequest userLoginRequest) {
        //走服务端登录服务
        Result loginResult = userService.login(userLoginRequest);
        if (loginResult.isSuccess()) {
            //服务端返回成功存入TOKEN
            User userModel = (User) loginResult.getResult();
            return new ResultUtil<>().setData(tokenManager.createToken(userModel.getId()));
        }
        return loginResult;
    }

    @GetMapping(value = "/info", produces = {"application/json;charset=UTF-8"})
    public Object userInfo(@CurrentUser String userId) {
        User userModel = userService.getUser(userId);
        return new ResultUtil<>().setData(userModel);
    }
}
