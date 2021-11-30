package io.itschool.courses.service.impl;

import io.itschool.courses.model.entity.Teacher;
import io.itschool.courses.repository.TeacherRepository;
import io.itschool.courses.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher create(Teacher teacher) {
        return teacherRepository.saveAndFlush(teacher);
    }

    @Override
    public void delete(String id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);

        teacher.ifPresent(teacherRepository::delete);
    }

    @Override
    public Teacher edit(String id, Teacher teacher) {
        Optional<Teacher> teacherOptional = teacherRepository.findById(id);

        if (teacherOptional.isEmpty()) {
            return  null;
        }

        Teacher savedTeacher = teacherOptional.get();
        savedTeacher.setName(teacher.getName());
        savedTeacher.setAge(teacher.getAge());
        return teacherRepository.saveAndFlush(savedTeacher);
    }

    @Override
    public Teacher findById(String id) {
        return teacherRepository.findById(id).orElse(null);
    }
}
