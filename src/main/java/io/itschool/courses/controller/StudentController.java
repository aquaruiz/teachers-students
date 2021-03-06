package io.itschool.courses.controller;

import io.itschool.courses.model.dto.students.*;
import io.itschool.courses.model.entity.Student;
import io.itschool.courses.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;
    private final ModelMapper modelMapper;

    @Autowired
    public StudentController(StudentService studentService, ModelMapper modelMapper) {
        this.studentService = studentService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentReadDTO> getById(@PathVariable String id) {
        Student savedStudent = studentService.findById(id);
        StudentReadDTO response = modelMapper.map(savedStudent, StudentReadDTO.class);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @PostMapping
    public ResponseEntity<StudentReadDTO> create(@RequestBody StudentCreateDTO request) {
        Student student = modelMapper.map(request, Student.class);

        Student savedStudent = studentService.create(student);
        StudentReadDTO response = modelMapper.map(savedStudent, StudentReadDTO.class);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {

        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentReadDTO> edit(@PathVariable String id, @RequestBody StudentEditDTO request) {
        Student student = modelMapper.map(request, Student.class);
        Student editedStudent = studentService.edit(id, student);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(modelMapper.map(editedStudent, StudentReadDTO.class));
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<StudentDetailsReadDTO> getDetailsById(@PathVariable String id) {
        Student savedStudent = studentService.findByIdWithGroupAndCourses(id);
        StudentDetailsReadDTO response = modelMapper.map(savedStudent, StudentDetailsReadDTO.class);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @PatchMapping("/{id}/details")
    public ResponseEntity<StudentDetailsReadDTO> editDetailsById(@PathVariable String id, @RequestBody StudentDetailsEditDTO request) {
        Student editedStudent = studentService.editStudentDetails(id, request.getCourseIds(), request.getGroupId());
        StudentDetailsReadDTO response = modelMapper.map(editedStudent, StudentDetailsReadDTO.class);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

}
