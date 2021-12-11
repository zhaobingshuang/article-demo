package org.example.entity;

import lombok.Data;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.11.17
 */
@Data
public class Student {
    private Integer id;

    private Byte age;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}