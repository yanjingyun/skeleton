package com.yjy.admin.module.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yjy.admin.module.sys.entity.AdminRole;
import com.yjy.admin.module.sys.entity.Role;
import com.yjy.admin.module.sys.mapper.UserRoleMapper;
import com.yjy.admin.module.sys.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 */
@SuppressWarnings({"SpringJavaInjectionPointsAutowiringInspection", "SpringJavaAutowiredFieldsWarningInspection"})
@Service
@CacheConfig(cacheNames = "adminRole")
public class IUserRoleServiceImpl extends ServiceImpl<UserRoleMapper, AdminRole> implements IUserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    @Cacheable(key = "#userId")
    public List<Role> findByUserId(String userId) {
        return userRoleMapper.findByUserId(userId);
    }
}
