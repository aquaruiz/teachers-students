package io.itschool.courses.model.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person extends BaseEntity {

    private String name;
    private int age;

    protected Person() {
    }

    protected Person(String id, String name, int age) {
        super(id);
        this.name = name;
        this.age = age;
    }
}
