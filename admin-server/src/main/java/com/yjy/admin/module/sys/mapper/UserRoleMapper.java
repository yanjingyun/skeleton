package com.yjy.admin.module.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yjy.admin.module.sys.entity.AdminRole;
import com.yjy.admin.module.sys.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 
 */
@Repository
public interface UserRoleMapper extends BaseMapper<AdminRole> {

    /**
     * 通过用户id获取
     *
     * @param userId 用户ID
     * @return 角色列表
     */
    List<Role> findByUserId(@Param("userId") String userId);
}
