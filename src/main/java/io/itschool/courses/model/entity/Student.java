package io.itschool.courses.model.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student extends Person {

    @ManyToOne(targetEntity = Group.class, fetch = FetchType.EAGER)
    private Group group;

    public Student() {
    }

    public Student(String id, String name, int age, Group group) {
        super(id, name, age);
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + getId() +
                ", name=" + getName() +
                ", age=" + getAge() +
                '}';
    }
}
