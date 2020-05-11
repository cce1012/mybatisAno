package com.cce.mapper;

import com.cce.po.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    List<User> findAll();
    User findById(int id);
    void add(User user);
    void update(User user);
}
