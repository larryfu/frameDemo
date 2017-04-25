package cn.larry.demo.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created by fugz on 2016/4/13.
 */
public class MybatisTest {

    public static void main(String[] args) {
        try {
            String resource = "mybatis/mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession();
            try {
                Person person = session.selectOne("cn.larry.mybatis.PersonMapper.selectPerson", "fu");
                System.out.println(person.getAge());
            } finally {
                session.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
