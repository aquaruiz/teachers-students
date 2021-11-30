package io.itschool.courses.service;

import io.itschool.courses.model.entity.Teacher;

public interface TeacherService {

    Teacher create(Teacher teacher);

    void delete(String id);

    Teacher edit(String id, Teacher teacher);

    Teacher findById(String id);
}
