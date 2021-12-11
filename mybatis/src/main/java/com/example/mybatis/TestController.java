package com.example.mybatis;

import com.example.mybatis.mapper.StudentMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.11.17
 */
@RestController
public class TestController {

    private final StudentMapper studentMapper;

    private final SqlSessionFactory sqlSessionFactory;

    public TestController(StudentMapper studentMapper, SqlSessionFactory sqlSessionFactory) {
        this.studentMapper = studentMapper;
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @GetMapping("/t1")
    public Object t1() {

        return studentMapper.selectByPrimaryKey(1);
    }

    @GetMapping("/t2")
    public Object t2() {
        return null;
    }
}
