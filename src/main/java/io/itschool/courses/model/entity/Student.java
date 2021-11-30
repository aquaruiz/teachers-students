package io.itschool.courses.model.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student extends Person {

    @ManyToOne
    private Group group;

}
