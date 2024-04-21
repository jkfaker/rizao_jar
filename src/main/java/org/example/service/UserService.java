package org.example.service;


import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Admin;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    Admin checkLogin(Admin admin);

    List<Admin> selectAllAdmin();
}
