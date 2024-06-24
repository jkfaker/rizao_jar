package org.example.service;

import org.example.pojo.Goods;
import org.example.pojo.GoodsCategory;
import org.example.pojo.User;
import org.example.pojo.UserInfo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserInfoService {
    void add(UserInfo userInfo);

    List<UserInfo> find(Integer id);

    void delete(Integer id) throws Exception;

    void update(UserInfo userInfo);

}
