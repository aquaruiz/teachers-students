package io.itschool.courses.service.impl;

import io.itschool.courses.model.entity.Course;
import io.itschool.courses.repository.CourseRepository;
import io.itschool.courses.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }
}
