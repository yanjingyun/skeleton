package com.yjy.user.module.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yjy.common.entity.BaseCommonEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * 用户数据库模型
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("user_info")
public class User extends BaseCommonEntity {

    private static final long serialVersionUID = 1859492908833095035L;

    private String username;

    private String password;

    private String mobile;

    private String email;

    private Integer status;

}
