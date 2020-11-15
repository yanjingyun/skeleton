package com.yjy.article.module.base.feign.impl;

import com.yjy.article.module.base.feign.UserFeignService;
import com.yjy.common.utils.ResultUtil;
import com.yjy.common.vo.Result;
import org.springframework.stereotype.Component;

/**
 * 这是关于用户服务的远程调用的错误回滚服务
 * 
 */
@Component
public class UserFeignServiceImpl implements UserFeignService {

    @Override
    public Result getUserInfo() {
        return new ResultUtil<>().setErrorMsg("从用户服务获取用户信息失败!");
    }
}
