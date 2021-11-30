package io.itschool.courses.service;

import io.itschool.courses.model.entity.Student;

public interface StudentService {

    Student create(Student student);

    void delete(String id);

    Student edit(String id, Student student);

    Student findById(String id);
}
