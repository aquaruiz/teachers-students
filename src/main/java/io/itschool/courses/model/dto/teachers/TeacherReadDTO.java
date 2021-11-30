package io.itschool.courses.model.dto.teachers;

public class TeacherReadDTO extends TeacherCreateDTO {

    private String id;

    public TeacherReadDTO() {
        // for mapping
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
