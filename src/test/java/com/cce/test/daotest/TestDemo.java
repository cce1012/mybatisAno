package com.cce.test.daotest;

import com.cce.dao.UserDao;
import com.cce.dao.impl.UserDaoImpl;
import com.cce.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class TestDemo {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws Exception {
        // 第一步：创建一个SQLSessionFactoryBuilder对象。
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 第二步：加载配置文件。
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 第三步：创建SQLSessionFactory对象
        sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
    }

    @Test
    public void findById() {
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        User user = userDao.findById(30);
        System.out.println(user);
    }

    @Test
    public void add() {
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        User user = new User();
        user.setAddress("上海");
        user.setBirthday(new Date());
        user.setUsername("x七");
        user.setSex("2");
        userDao.add(user);
        System.out.println(user.getId());
    }

    @Test
    public void update() {
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        User user = new User();
        user.setId(31);
        user.setUsername("cc");
        userDao.update(user);
    }
}
