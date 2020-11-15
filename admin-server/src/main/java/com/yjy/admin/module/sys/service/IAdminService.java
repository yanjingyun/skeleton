package com.yjy.admin.module.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yjy.admin.module.sys.entity.Admin;

/**
 * <p>
 * 服务类
 * </p>
 *
 * 
 * @since 2019-03-06
 */
public interface IAdminService extends IService<Admin> {

    /**
     * 获取用户详情令牌
     * <p>
     * 包括 用户令牌， 权限，部门
     *
     * @param username 用户名
     * @return 用户详细信息
     */
    Admin findUserDetailInfo(String username);
}
