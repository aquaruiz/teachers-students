package io.itschool.courses.service;

import io.itschool.courses.model.entity.Student;

import java.util.List;

public interface StudentService {

    Student create(Student student);

    void delete(String id);

    Student edit(String id, Student student);

    Student findById(String id);

    Student findByIdWithGroupAndCourses(String id);

    Student editStudentDetails(String id, List<String> courseIds, String groupId);
}
