package com.yjy.admin.module.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yjy.admin.module.sys.entity.Role;
import com.yjy.admin.module.sys.mapper.RoleMapper;
import com.yjy.admin.module.sys.service.IRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * 
 * @since 2019-03-07
 */
@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
