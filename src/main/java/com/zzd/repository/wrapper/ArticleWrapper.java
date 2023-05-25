package com.zzd.repository.wrapper;

import com.zzd.entity.Article;
import com.zzd.vo.ArticleVo;
import com.zzd.vo.PageVo;

import java.util.List;

public interface ArticleWrapper {
    List<Article> listArticles(PageVo page);

    List<Article> listArticles(ArticleVo article, PageVo page);

    List<ArticleVo> listArchives();

}
