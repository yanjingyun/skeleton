package com.yjy.user.module.base.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yjy.user.module.base.entity.User;

/**
 * 用户Mapper
 * 
 */
public interface UserMapper extends BaseMapper<User> {
    /**
     * 通过用户ID查找
     * @param username 用户名
     * @return 用户实体
     */
    User selectByUsername(String username);

    /**
     * 通过用户ID查找
     * @param mobile 用户手机号
     * @return 用户实体
     */
    User selectByMobile(String mobile);

    /**
     * 通过用户ID查找
     * @param account 用户手机号或用户名
     * @return 用户实体
     */
    User selectByUsernameOrMobile(String account);
}