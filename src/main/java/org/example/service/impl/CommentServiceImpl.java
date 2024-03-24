package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.mapper.CommentMapper;
import org.example.pojo.Comment;
import org.example.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> find(Integer goodsId) {

        return commentMapper.selectById(goodsId);
    }
}
