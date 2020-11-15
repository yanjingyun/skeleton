package com.yjy.article.module.base.service;

import com.yjy.common.vo.Result;

/**
 * 用户相关api本地服务接口的示例服务
 */
public interface IUserLocalService {
    /**
     * 获取用户信息
     * @param name 名字
     * @return 结果
     */
	Result<Object> sayHello(String name);
}
