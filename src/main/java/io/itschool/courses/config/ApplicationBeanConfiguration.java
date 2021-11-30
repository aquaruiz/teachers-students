package io.itschool.courses.config;

import io.itschool.courses.model.dto.students.StudentDetailsReadDTO;
import io.itschool.courses.model.entity.Student;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguration {
    @Bean
    public ModelMapper modelMapper() {

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(true);

        mapper.typeMap(Student.class, StudentDetailsReadDTO.class)
                .addMapping(i -> i.getGroup().getCourses(), StudentDetailsReadDTO::setCourses);

        return mapper;
    }

}
