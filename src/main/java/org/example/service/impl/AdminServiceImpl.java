package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.mapper.AdminMapper;
import org.example.pojo.Admin;
import org.example.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AdminServiceImpl implements AdminService {
    
    @Autowired
    private AdminMapper adminMapper;
    
    @Override
    public Admin checkLogin(Admin admin) {
        return adminMapper.checkLoginByUsernameAndPassword(admin);
    }

    @Override
    public List<Admin> selectAllAdmin() {
        return adminMapper.selectAllAdmin();
    }
}
