package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.mapper.AdminMapper;
import org.example.mapper.UserInfoMapper;
import org.example.mapper.UserMapper;
import org.example.pojo.Admin;
import org.example.pojo.User;
import org.example.pojo.UserInfo;
import org.example.service.AdminService;
import org.example.service.SmsService;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private SmsService smsService;

    @Override
    public User checkLogin(User user) {
        return userMapper.checkLoginByUsernameAndPassword(user);
    }

    @Override
    public List<User> selectAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        userInfoMapper.deleteById(id);
        userMapper.delete(id);
    }


    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
        LocalDateTime registerTime = LocalDateTime.now();
        user.setRegisterDate(registerTime);
        userInfoMapper.register(user);
    }

    @Override
    public Integer registerVerify(User user, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String phone = user.getPhone();
        String code = user.getCode();
        return smsService.codeVerify(phone, code, session);
    }
}