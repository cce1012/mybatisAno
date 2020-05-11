package com.cce.test;

import com.cce.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;

public class TestDemo {
    private SqlSessionFactory factory =null;

    @Before
    public void init() throws IOException {
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = factoryBuilder.build(Resources.getResourceAsStream("sqlMapConfig.xml"));
    }


    @Test
    public void findById() throws IOException {
        SqlSession sqlSession = factory.openSession();
        User user = sqlSession.selectOne("findById", 1);
        System.out.println(user);
    }

    @Test
    public void add() throws IOException {
        User user = new User();
        user.setAddress("上海");
        user.setBirthday(new Date());
        user.setUsername("田七");
        user.setSex("2");
        SqlSession sqlSession = factory.openSession();
        sqlSession.update("add",user);
        System.out.println(user.getId());
        sqlSession.commit();
    }

    @Test
    public void update() throws IOException {
        User user = new User();
        user.setId(30);
        user.setUsername("77");
        SqlSession sqlSession = factory.openSession();
        sqlSession.update("update",user);
        sqlSession.commit();
    }
}
