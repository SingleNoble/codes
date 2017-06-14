package com.cmfz.service.impl;

import com.cmfz.dao.FeedBackDao;
import com.cmfz.entity.Feedback;
import com.cmfz.service.FeedbackService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("feedback")
@Transactional
public class FeedbackServiceImpl implements FeedbackService {


    @Resource
    private FeedBackDao feedBackDao;

    public Page<Feedback> queryAll(Integer page, Integer rows) {

        Page<Feedback> pages = PageHelper.startPage(page, rows);
        feedBackDao.selectAll();
        return pages;
    }
}
