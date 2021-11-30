package io.itschool.courses.controller;


import io.itschool.courses.model.dto.teachers.TeacherCreateDTO;
import io.itschool.courses.model.dto.teachers.TeacherEditDTO;
import io.itschool.courses.model.dto.teachers.TeacherReadDTO;
import io.itschool.courses.model.entity.Teacher;
import io.itschool.courses.service.TeacherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    private final TeacherService teacherService;
    private final ModelMapper modelMapper;

    @Autowired
    public TeacherController(TeacherService teacherService, ModelMapper modelMapper) {
        this.teacherService = teacherService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherReadDTO> getById(@PathVariable String id) {
        Teacher savedTeacher = teacherService.findById(id);
        TeacherReadDTO response = modelMapper.map(savedTeacher, TeacherReadDTO.class);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @PostMapping
    public ResponseEntity<TeacherReadDTO> create(@RequestBody TeacherCreateDTO request) {
        Teacher teacher = modelMapper.map(request, Teacher.class);

        Teacher savedTeacher = teacherService.create(teacher);
        TeacherReadDTO response = modelMapper.map(savedTeacher, TeacherReadDTO.class);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        teacherService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherReadDTO> edit(@PathVariable String id, @RequestBody TeacherEditDTO request) {
        Teacher teacher = modelMapper.map(request, Teacher.class);
        Teacher editedTeacher = teacherService.edit(id, teacher);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(modelMapper.map(editedTeacher, TeacherReadDTO.class));
    }
}
