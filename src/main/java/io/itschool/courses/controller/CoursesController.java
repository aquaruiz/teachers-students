package io.itschool.courses.controller;


import io.itschool.courses.model.dto.CourseDTO;
import io.itschool.courses.model.entity.Course;
import io.itschool.courses.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/courses")
public class CoursesController {

    private final CourseService courseService;
    private final ModelMapper modelMapper;

    @Autowired
    public CoursesController(CourseService courseService, ModelMapper modelMapper) {
        this.courseService = courseService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAll() {
        List<Course> allCourses = courseService.getAll();

        List<CourseDTO> courseDtos = allCourses.stream()
                .map(s -> modelMapper.map(s, CourseDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(courseDtos);
    }
}
