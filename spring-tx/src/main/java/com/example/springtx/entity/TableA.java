package com.example.springtx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TableA {

    private Integer id;

    private String name;

    public TableA(String name) {
        this.name = name;
    }
}
