package io.itschool.courses.service.impl;

import io.itschool.courses.model.entity.Course;
import io.itschool.courses.model.entity.Group;
import io.itschool.courses.model.entity.Student;
import io.itschool.courses.repository.CourseRepository;
import io.itschool.courses.repository.GroupRepository;
import io.itschool.courses.repository.StudentRepository;
import io.itschool.courses.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, GroupRepository groupRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
        this.courseRepository = courseRepository;
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

    @Override
    public Student findByIdWithGroupAndCourses(String id) {
        return studentRepository.findByIdWithGroupAndCourses(id).orElse(null);
    }

    @Override
    public Student editStudentDetails(String id, List<String> courseIds, String groupId) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isEmpty()) { return null; }

        Student savedStudent = studentOptional.get();
        if (groupId != null) {
            Optional<Group> savedGroup = groupRepository.findById(groupId);
            if (savedGroup.isPresent()){
                Group currentGroup = savedGroup.get();
                currentGroup.addStudent(savedStudent);
                savedStudent.setGroup(currentGroup);
                groupRepository.save(currentGroup);
            }
        }

        if (!courseIds.isEmpty()) {
            courseIds.forEach(i -> {
                Optional<Course> savedCourse = courseRepository.findById(i);
                if (savedCourse.isPresent()){
                    Course currentCourse = savedCourse.get();
                    savedStudent.getGroup().addCourse(currentCourse);
                }
            });
        }

        return studentRepository.saveAndFlush(savedStudent);
    }
}
