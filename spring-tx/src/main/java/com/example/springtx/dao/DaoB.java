package com.example.springtx.dao;

import com.example.springtx.entity.TableB;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DaoB {
    private final JdbcTemplate jdbcTemplate;


    public DaoB(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(TableB tableB) {
        jdbcTemplate.update("insert into table_b(id, name) value (?, ?)", tableB.getId(), tableB.getName());
    }
}
