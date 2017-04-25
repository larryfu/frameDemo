package cn.larry;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created by Thinkpad on 2015/11/12.
 */
public class MybatisTest {
    public static void main(String[] args){
        try{
            String resource = "cn/larry/mybatis/mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession();
            try {
                Person person = session.selectOne("cn.larry.mybatis.PersonMapper.selectPerson", "larryfu");
                System.out.println(person.getAge());

            } finally {
                session.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
