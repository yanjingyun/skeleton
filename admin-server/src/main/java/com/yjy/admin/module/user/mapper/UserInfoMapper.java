package com.yjy.admin.module.user.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yjy.admin.module.user.entity.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yjy.common.vo.ExtraVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * 
 * @since 2020-03-02
 */
@Repository
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    /**
     * 获取用户列表
     *
     * @param page        分页
     * @param userInfo    搜索参数
     * @param extraVo     额外参数
     * @return 用户列表
     */
    IPage<UserInfo> selectUserList(
            IPage page, @Param("userInfo") UserInfo userInfo, @Param("extraVo") ExtraVo extraVo);

    /**
     * 通过用户ID查找
     * @param username 用户名
     * @return 用户实体
     */
    UserInfo selectByUsername(String username);

    /**
     * 通过用户ID查找
     * @param mobile 用户手机号
     * @return 用户实体
     */
    UserInfo selectByMobile(String mobile);
}
