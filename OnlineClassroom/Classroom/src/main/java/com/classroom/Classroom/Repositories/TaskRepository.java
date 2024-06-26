package com.classroom.Classroom.Repositories;

import com.classroom.Classroom.Entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task>findByStudentStudentId(Long studentId);
}
