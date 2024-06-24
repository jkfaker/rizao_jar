package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.pojo.User;
import org.example.pojo.UserInfo;

import java.util.List;

@Mapper
public interface UserInfoMapper {
    @Insert("insert into rizao.user_info(avatar, gender, username, job, email, phone, address, last_login_date, shopping_preferences) values ( #{avatar}, #{gender}, #{username}, #{job}, #{email}, #{phone}, #{address}, #{lastLoginDate}, #{shoppingPreferences});")
    void add(UserInfo userInfo);

    @Select("select * from rizao.user_info where user_id = #{id}")
    List<UserInfo> selectByAny(Integer id);

    @Delete("delete from rizao.user_info where user_id = #{id} ")
    void deleteById(Integer id);

    @Update("UPDATE rizao.user_info SET avatar = #{avatar}, gender = #{gender}, username = #{username}, job = #{job}, email = #{email}, phone = #{phone}, address = #{address}, shopping_preferences = #{shoppingPreferences} WHERE user_id = #{userId}")
    void update(UserInfo goods);

    @Insert("insert into rizao.user_info(user_id, username, phone, register_date) values ( #{userId},#{username},#{phone},#{registerDate})")
    void register(User user);

}
