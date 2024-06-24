package org.example.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.Admin;

import java.util.List;

@Mapper
public interface AdminMapper {

    @Select("select * from rizao.admin where username = #{username} and password = #{password}")
    Admin checkLoginByUsernameAndPassword(Admin admin);

    @Select("select id,head_sculpture, username, phone from rizao.admin")
    List<Admin> selectAllAdmin();
}
