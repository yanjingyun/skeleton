package com.yjy.article.module.article.service.impl;

import com.yjy.article.module.article.entity.ArticleInfo;
import com.yjy.article.module.article.mapper.ArticleInfoMapper;
import com.yjy.article.module.article.service.IArticleInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章表 服务实现类
 * </p>
 *
 * 
 * @since 2020-03-01
 */
@Service
public class ArticleInfoServiceImpl extends ServiceImpl<ArticleInfoMapper, ArticleInfo> implements IArticleInfoService {

}
