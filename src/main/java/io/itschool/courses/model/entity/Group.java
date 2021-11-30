package io.itschool.courses.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group extends BaseEntity {

    private String name;

    @ManyToMany(targetEntity = Course.class, fetch = FetchType.EAGER)
    @JoinTable(name = "groups_courses",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;

    @OneToMany(mappedBy = "group")
    private List<Student> students;

    public Group() {
        super();
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public Group(String id, String name) {
        super(id);
        this.name = name;
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return Collections.unmodifiableList(courses);
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    @Override
    public String toString() {
        return "Group{" +
                "id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                ", courses=" + courses +
                ", students=" + students +
                '}';
    }
}
