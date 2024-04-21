package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.mapper.UserMapper;
import org.example.pojo.Admin;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserMapper userMapper;
    
    @Override
    public Admin checkLogin(Admin admin) {
        return userMapper.checkLoginByUsernameAndPassword(admin);
    }

    @Override
    public List<Admin> selectAllAdmin() {
        return userMapper.selectAllAdmin();
    }
}
