package org.example.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.Admin;

@Mapper
public interface UserMapper {

    @Select("select * from rizao.admin where username = #{username} and password = #{password}")
    Admin checkLoginByUsernameAndPassword(Admin admin);
}