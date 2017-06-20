package com.cmfz.service.impl;

import com.cmfz.dao.ArticleDao;
import com.cmfz.entity.Article;
import com.cmfz.service.ArticleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * Created by 31677 on 2017/6/14.
 */
@Service("articleService")
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;

    public void add(Article article) {
        article.setId(UUID.randomUUID().toString());
        article.setCreatedate(new Date());
        articleDao.insert(article);
    }

    public void drop(String id) {
        articleDao.delete(id);
    }

    public Page<Article> queryAllByPage(Integer page, Integer rows) {
        Page<Article> articles=PageHelper.startPage(page,rows);
        articleDao.selectAll();
        return articles;
    }
    public Article queryOneById(String id){

        return articleDao.selectById(id);
    }
}
