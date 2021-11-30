package io.itschool.courses.model.dto.students;

public class StudentReadDTO extends StudentCreateDTO {

    private String id;

    public StudentReadDTO() {
        // for mapping
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
