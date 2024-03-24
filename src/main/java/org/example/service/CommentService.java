package org.example.service;
import org.example.pojo.Comment;

import java.util.List;


public interface CommentService {
    List<Comment> find(Integer goodsId);
}
