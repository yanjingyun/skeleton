package com.yjy.admin.module.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yjy.admin.module.sys.entity.AdminRole;
import com.yjy.admin.module.sys.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 */
public interface IUserRoleService extends IService<AdminRole> {

    /**
     * 通过用户id获取
     *
     * @param userId 用户主键
     * @return 角色列表
     */
    List<Role> findByUserId(@Param("userId") String userId);
}
