package org.example;

import lombok.SneakyThrows;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.entity.Student;
import org.example.mapper.StudentMapper;

import java.io.InputStream;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//        System.out.println("Hello World!");
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            StudentMapper studentMapper2 = sqlSession.getMapper(StudentMapper.class);

            System.out.println(studentMapper == studentMapper2);

            Student student = studentMapper.selectByPrimaryKey(1);
            System.out.println(student);
        }
    }

    @SneakyThrows
    public static SqlSessionFactory getSqlSessionFactory() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

}
