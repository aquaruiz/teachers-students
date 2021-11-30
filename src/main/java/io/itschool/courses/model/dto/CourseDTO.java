package io.itschool.courses.model.dto;

public class CourseDTO {

    private String id;
    private String name;

    public CourseDTO() {
        // for mapping
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
