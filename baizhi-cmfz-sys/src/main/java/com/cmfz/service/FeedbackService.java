package com.cmfz.service;

import com.cmfz.entity.Feedback;
import com.cmfz.entity.Master;
import com.github.pagehelper.Page;


/**
 * Created by 梵辰 on 2017/6/13.
 */
public interface FeedbackService {



    /*查询所有上师*/
    Page<Feedback> queryAll(Integer page, Integer rows);

}
