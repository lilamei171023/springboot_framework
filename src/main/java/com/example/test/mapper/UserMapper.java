package com.example.test.mapper;

import com.example.test.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from users where id = #{id}")
    User findUserByUserid(@Param("id") String userId);
    @Insert("insert into users (user_name,user_age) values (#{user_name},#{user_age})")
    boolean insertUsers (@Param("user_age") String userAge,@Param("user_name") String pwd);
}