package io.itschool.courses.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "teachers")
public class Teacher extends Person {

    @ManyToMany(targetEntity = Course.class)
    @JoinTable(name = "teachers_courses",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;

    public Teacher() {
        this.courses = new ArrayList<>();
    }

    public Teacher(String id, String name, int age) {
        super(id, name, age);
        this.courses = new ArrayList<>();
    }

    public List<Course> getCourses() {
        return Collections.unmodifiableList(courses);
    }

    public void addCourse(Course course) {
        this.courses.add(course);
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
