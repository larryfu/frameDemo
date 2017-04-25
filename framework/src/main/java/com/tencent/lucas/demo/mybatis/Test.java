package com.tencent.lucas.demo.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Created by lucasfu on 2017/4/20.
 */
public class Test {
    public static void main(String[] args) {
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(Test.class.getResourceAsStream("/mybatis/mybatis-config.xml"));
        SqlSession session = sessionFactory.openSession();
        Integer i = session.selectOne("com.tencent.lucas.demo.mybatis.dal.EveningBonusPoolMapper.getCurrentRound");
    }
}
