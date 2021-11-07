package com.example.springtx.dao;

import com.example.springtx.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    private JdbcTemplate jdbcTemplate;


    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(User user) {
        jdbcTemplate.update("insert into user(id, name) value (?, ?)", user.getId(), user.getName());
    }
}
