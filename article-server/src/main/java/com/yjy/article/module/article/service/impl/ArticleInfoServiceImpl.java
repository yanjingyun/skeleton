package com.yjy.article.module.article.service.impl;

import com.yjy.article.module.article.entity.ArticleInfo;
import com.yjy.article.module.article.mapper.ArticleInfoMapper;
import com.yjy.article.module.article.service.IArticleInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 文章表 服务实现类
 */
@Service
public class ArticleInfoServiceImpl extends ServiceImpl<ArticleInfoMapper, ArticleInfo> implements IArticleInfoService {

}
