package com.cce.dao.impl;

import com.cce.dao.UserDao;
import com.cce.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


public class UserDaoImpl implements UserDao {
    SqlSessionFactory factory=null;

    public UserDaoImpl(SqlSessionFactory factory){
        this.factory=factory;
    }
    public User findById(int id) {
        SqlSession sqlSession = factory.openSession();
        User user = sqlSession.selectOne("findById",id);
        sqlSession.close();
        return user;
    }

    public void add(User user) {
        SqlSession sqlSession = factory.openSession();
        sqlSession.update("add",user);
        System.out.println(user.getId());
        sqlSession.commit();
        sqlSession.close();
    }

    public void update(User user) {
        SqlSession sqlSession = factory.openSession();
        sqlSession.update("update",user);
        sqlSession.commit();
        sqlSession.close();
    }
}
