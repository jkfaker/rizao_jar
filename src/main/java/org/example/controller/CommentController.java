package org.example.controller;


import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Comment;
import org.example.pojo.Result;
import org.example.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    /*
    * 通过商品id查找所有评论，当id缺省时显示全部，并且order by 时间
    **/
    @RequestMapping( value = {"/comment", "/manage/comment"})
    public Result find(Integer goodsId)
    {
        List<Comment> comment =  commentService.find(goodsId);
        log.info("查询了商品id为{id}的评论");
        return Result.success(comment);
    }
}


