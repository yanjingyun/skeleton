package com.yjy.admin.module.article.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yjy.admin.module.article.entity.ArticleInfo;
import com.yjy.common.vo.ExtraVo;

/**
 * <p>
 * 文章表 服务类
 * </p>
 *
 * 
 * @since 2019-04-05
 */
public interface IArticleInfoService extends IService<ArticleInfo> {

    /**
     * 获取文章列表
     *
     * @param page        分页
     * @param articleInfo 搜索参数
     * @param extraVo     额外参数
     * @return 文章列表
     */
    IPage<ArticleInfo> getArticleList(IPage page, ArticleInfo articleInfo, ExtraVo extraVo);
}
