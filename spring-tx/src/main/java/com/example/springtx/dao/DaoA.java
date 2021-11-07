package com.example.springtx.dao;

import com.example.springtx.entity.TableA;
import com.example.springtx.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DaoA {
    private final JdbcTemplate jdbcTemplate;


    public DaoA(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(TableA tableA) {
        jdbcTemplate.update("insert into table_a(id, name) value (?, ?)", tableA.getId(), tableA.getName());
    }
}
