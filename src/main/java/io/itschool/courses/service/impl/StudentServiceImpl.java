package io.itschool.courses.service.impl;

import io.itschool.courses.model.entity.Student;
import io.itschool.courses.repository.StudentRepository;
import io.itschool.courses.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student create(Student student) {
        return studentRepository.saveAndFlush(student);
    }

    @Override
    public void delete(String id) {
        Optional<Student> student = studentRepository.findById(id);

        student.ifPresent(studentRepository::delete);
    }

    @Override
    public Student edit(String id, Student student) {
        Optional<Student> studentOptional = studentRepository.findById(id);

        if (studentOptional.isEmpty()) {
            return  null;
        }

        Student savedStudent = studentOptional.get();
        savedStudent.setName(student.getName());
        savedStudent.setAge(student.getAge());
        return studentRepository.saveAndFlush(savedStudent);
    }

    @Override
    public Student findById(String id) {
        return studentRepository.findById(id).orElse(null);
    }
}
