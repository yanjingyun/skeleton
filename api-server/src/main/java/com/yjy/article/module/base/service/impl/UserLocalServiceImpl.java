package com.yjy.article.module.base.service.impl;

import com.yjy.article.module.base.service.IUserLocalService;
import com.yjy.common.utils.ResultUtil;
import com.yjy.common.vo.Result;
import org.springframework.stereotype.Service;

/**
 * 用户相关api本地服务实现的示例服务
 * 
 */
@Service
public class UserLocalServiceImpl implements IUserLocalService {

    /**
     * 获取用户信息
     * @param name 名字
     * @return 结果
     */
    @Override
    public Result sayHello(String name) {
        return new ResultUtil<>().setSuccessMsg("Hello:" + name);
    }
}
