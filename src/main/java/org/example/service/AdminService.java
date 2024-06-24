package org.example.service;


import org.example.pojo.Admin;

import java.util.List;


public interface AdminService {
    Admin checkLogin(Admin admin);

    List<Admin> selectAllAdmin();
}
