package io.itschool.courses.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course extends BaseEntity {

    private String name;

    @Enumerated(EnumType.STRING)
    private CourseTypeEnum courseType;

    @ManyToMany(mappedBy = "courses")
    private List<Group> groups;

    @ManyToOne
    private Teacher teacher;

}
