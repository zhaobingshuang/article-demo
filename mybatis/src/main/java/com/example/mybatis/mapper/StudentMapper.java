package com.example.mybatis.mapper;

import com.example.mybatis.entity.Student;
import org.springframework.stereotype.Repository;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.11.17
 */
@Repository
public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}