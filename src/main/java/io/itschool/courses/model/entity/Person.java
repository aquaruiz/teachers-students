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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
