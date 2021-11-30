package io.itschool.courses.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group extends BaseEntity {

    private String name;

    @ManyToMany(targetEntity = Course.class)
    @JoinTable(name = "groups_courses",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;

    @OneToMany(mappedBy = "group")
    private List<Student> students;

}
