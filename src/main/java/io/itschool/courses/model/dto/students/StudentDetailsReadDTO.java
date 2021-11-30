package io.itschool.courses.model.dto.students;

import io.itschool.courses.model.dto.CourseDTO;
import io.itschool.courses.model.dto.GroupDTO;

import java.util.List;

public class StudentDetailsReadDTO extends StudentCreateDTO {

    private String id;
    private GroupDTO group;
    private List<CourseDTO> courses;

    public StudentDetailsReadDTO() {
        // for mapping
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GroupDTO getGroup() {
        return group;
    }

    public void setGroup(GroupDTO group) {
        this.group = group;
    }

    public List<CourseDTO> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDTO> courses) {
        this.courses = courses;
    }
}
