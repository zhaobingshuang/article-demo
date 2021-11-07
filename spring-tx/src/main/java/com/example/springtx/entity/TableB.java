package com.example.springtx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TableB {

    private Integer id;

    private String name;

    public TableB(String name) {
        this.name = name;
    }
}
