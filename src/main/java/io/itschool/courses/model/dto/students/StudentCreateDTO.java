package io.itschool.courses.model.dto.students;

public class StudentCreateDTO {

    private String name;
    private int age;

    public StudentCreateDTO(){
        // for mapping
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
