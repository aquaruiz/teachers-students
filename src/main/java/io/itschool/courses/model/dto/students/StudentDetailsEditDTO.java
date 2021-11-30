package io.itschool.courses.model.dto.students;

import java.util.List;

public class StudentDetailsEditDTO {

    private String groupId;
    private List<String> courseIds;

    public StudentDetailsEditDTO() {
        // for mapping
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<String> getCourseIds() {
        return courseIds;
    }

    public void setCourseIds(List<String> courseIds) {
        this.courseIds = courseIds;
    }
}
