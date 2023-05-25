package com.zzd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zzd.entity.Article;
import com.zzd.entity.Comment;

/**
 * @author zzd
 * <p>
 * 2018年1月25日
 */
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findByArticleAndLevelOrderByCreateDateDesc(Article a, String level);


}
