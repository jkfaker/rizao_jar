package org.example.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.Comment;

import java.util.List;

@Mapper
public interface CommentMapper {
    List<Comment> selectById(Integer goodsId);
}
