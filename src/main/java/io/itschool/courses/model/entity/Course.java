package io.itschool.courses.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course extends BaseEntity {

    private String name;

    @Enumerated(EnumType.STRING)
    private CourseTypeEnum courseType;

    @ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL)
    private List<Group> groups;

    @ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL)
    private List<Teacher> teachers;

    public Course() {
        this.groups = new ArrayList<>();
        this.teachers = new ArrayList<>();
    }

    public Course(String id, String name, CourseTypeEnum courseType) {
        super(id);
        this.name = name;
        this.courseType = courseType;
        this.groups = new ArrayList<>();
        this.teachers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CourseTypeEnum getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseTypeEnum courseType) {
        this.courseType = courseType;
    }

    public List<Group> getGroups() {
        return Collections.unmodifiableList(groups);
    }

    public void addGroup(Group group) {
        this.groups.add(group);
    }

    public List<Teacher> getTeachers() {
        return Collections.unmodifiableList(teachers);
    }

    public void addTeacher(Teacher teacher) {
        this.teachers.add(teacher);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + getId() + '\'' +
                "name='" + name + '\'' +
                ", courseType=" + courseType +
                '}';
    }
}
