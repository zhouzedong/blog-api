package com.zzd.vo;

import com.zzd.entity.Tag;

/**
 * @author zzd
 * <p>
 * 2018年1月29日
 */
public class TagVO extends Tag {

    /**
     *
     */
    private static final long serialVersionUID = 5059212992497947120L;
    private int articles;

    public int getArticles() {
        return articles;
    }

    public void setArticles(int articles) {
        this.articles = articles;
    }


}
