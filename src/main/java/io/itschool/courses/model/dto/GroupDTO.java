package io.itschool.courses.model.dto;

public class GroupDTO {

    private String id;
    private String name;

    public GroupDTO() {
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
