package com.classroom.Classroom.Services;

import com.classroom.Classroom.Repositories.StudentRepository;
import com.classroom.Classroom.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TaskRepository taskRepository;

}
