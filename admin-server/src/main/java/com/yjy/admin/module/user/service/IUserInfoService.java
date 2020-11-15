package com.yjy.admin.module.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yjy.admin.module.user.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yjy.common.vo.ExtraVo;
import com.yjy.common.vo.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * 
 * @since 2020-03-02
 */
public interface IUserInfoService extends IService<UserInfo> {

    /**
     * 获取用户列表
     *
     * @param page        分页
     * @param userInfo 搜索参数
     * @param extraVo     额外参数
     * @return 用户列表
     */
    IPage<UserInfo> getUserList(IPage page, UserInfo userInfo, ExtraVo extraVo);

    /**
     * 添加用户
     * @param userInfo 用户信息
     * @return Result
     */
    Result<Object> addUser(UserInfo userInfo);

    /**
     * 修改用户密码
     * @param id 用户ID
     * @param password 密码
     * @return Result
     */
    Result<Object> updatePassword(String id, String password);
}
