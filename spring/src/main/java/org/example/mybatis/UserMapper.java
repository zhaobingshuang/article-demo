package org.example.mybatis;

public interface UserMapper {

    void insertUser(User user);

    User getUser(Integer id);

}
