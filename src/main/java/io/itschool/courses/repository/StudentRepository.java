package io.itschool.courses.repository;

import io.itschool.courses.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

    @Query("select s from Student s join s.group join s.group.courses where s.id = :id")
    Optional<Student> findByIdWithGroupAndCourses(String id);

}
