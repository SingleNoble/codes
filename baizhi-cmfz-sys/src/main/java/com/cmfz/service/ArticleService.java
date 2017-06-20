package com.cmfz.service;

import com.cmfz.entity.Article;
import com.github.pagehelper.Page;

/**
 * Created by 31677 on 2017/6/14.
 */
public interface ArticleService {

    public void add(Article article);
    public void drop(String id);

    public Page<Article> queryAllByPage(Integer page, Integer rows);

    public Article queryOneById(String id);
}
