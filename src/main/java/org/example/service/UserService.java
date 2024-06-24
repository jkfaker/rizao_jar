package org.example.service;

import org.example.pojo.Admin;
import org.example.pojo.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {
    User checkLogin(User user);

    List<User> selectAllUser();

    void delete(Integer id);

    void addUser(User user);

    Integer registerVerify(User user, HttpServletRequest request);
}

