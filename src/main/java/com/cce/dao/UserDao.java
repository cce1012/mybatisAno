package com.cce.dao;

import com.cce.po.User;
import org.apache.ibatis.annotations.Select;

public interface UserDao {
    User findById(int id);
    void add(User user);
    void update(User user);
}
