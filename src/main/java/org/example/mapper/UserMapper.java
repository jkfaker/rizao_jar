package org.example.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.Admin;
import org.example.pojo.User;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from rizao.user where username = #{username} and password = #{password}")
    User checkLoginByUsernameAndPassword(User user);

    @Select("select user_id, username, password, email, phone from rizao.user")
    List<User> selectAllUser();


    @Delete("delete from rizao.user where user_id = #{id}")
    void delete(Integer id);

    @Insert("insert into rizao.user(username, password, email, phone) values(#{username}, #{password}, #{email}, #{phone})")
    void addUser(User user);
}
