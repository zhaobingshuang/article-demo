package org.example.mapper;

import org.example.entity.Student;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.11.17
 */
public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}