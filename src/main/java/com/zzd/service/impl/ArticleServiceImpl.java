package com.zzd.service.impl;

import java.util.Date;
import java.util.List;

import com.zzd.vo.ArticleVo;
import com.zzd.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzd.common.util.UserUtils;
import com.zzd.entity.Article;
import com.zzd.entity.Category;
import com.zzd.entity.Tag;
import com.zzd.entity.User;
import com.zzd.repository.ArticleRepository;
import com.zzd.service.ArticleService;

/**
 * @author zzd
 * <p>
 * 2018年1月25日
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;


    @Override
    public List<Article> listArticles(PageVo page) {

        return articleRepository.listArticles(page);
    }

    @Override
    public List<Article> listArticles(ArticleVo article, PageVo page) {

        return articleRepository.listArticles(article, page);
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public Article getArticleById(Integer id) {
        return articleRepository.getOne(id);
    }

    @Override
    @Transactional
    public Integer publishArticle(Article article) {

        if(null != article.getId()){
            return this.updateArticle(article);
        }else{
            return this.saveArticle(article);
        }

    }

    @Override
    @Transactional
    public Integer saveArticle(Article article) {

        User currentUser = UserUtils.getCurrentUser();

        if (null != currentUser) {
            article.setAuthor(currentUser);
        }

        article.setCreateDate(new Date());
        article.setWeight(Article.Article_Common);

        return articleRepository.save(article).getId();
    }

    @Override
    @Transactional
    public Integer updateArticle(Article article) {
        Article oldArticle = articleRepository.getOne(article.getId());

        oldArticle.setTitle(article.getTitle());
        oldArticle.setSummary(article.getSummary());
        oldArticle.setBody(article.getBody());
        oldArticle.setCategory(article.getCategory());
        oldArticle.setTags(article.getTags());

        return oldArticle.getId();
    }

    @Override
    @Transactional
    public void deleteArticleById(Integer id) {
        articleRepository.delete(id);
    }

    @Override
    public List<Article> listArticlesByTag(Integer id) {
        Tag t = new Tag();
        t.setId(id);
        return articleRepository.findByTags(t);
    }

    @Override
    public List<Article> listArticlesByCategory(Integer id) {
        Category c = new Category();
        c.setId(id);

        return articleRepository.findByCategory(c);
    }

    @Override
    @Transactional
    public Article getArticleAndAddViews(Integer id) {
        int count = 1;
        Article article = articleRepository.getOne(id);
        article.setViewCounts(article.getViewCounts() + count);
        return article;
    }

    @Override
    public List<Article> listHotArticles(int limit) {

        return articleRepository.findOrderByViewsAndLimit(limit);
    }

    @Override
    public List<Article> listNewArticles(int limit) {

        return articleRepository.findOrderByCreateDateAndLimit(limit);
    }

    @Override
    public List<ArticleVo> listArchives() {

        return articleRepository.listArchives();
    }
}