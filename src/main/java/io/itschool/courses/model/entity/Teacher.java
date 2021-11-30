package io.itschool.courses.model.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "teachers")
public class Teacher extends Person {

    @OneToMany(mappedBy = "teacher")
    private List<Course> courses;

}
