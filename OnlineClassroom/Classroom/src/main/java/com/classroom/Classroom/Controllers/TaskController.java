package com.classroom.Classroom.Controllers;

import com.classroom.Classroom.Entities.Student;
import com.classroom.Classroom.Entities.Task;
import com.classroom.Classroom.Repositories.ClassroomRepository;
import com.classroom.Classroom.Repositories.TaskRepository;
import com.classroom.Classroom.Services.StudentService;
import com.classroom.Classroom.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController

public class TaskController {
    private ClassroomRepository classroomRepository;
    private StudentService studentService;
    private TaskService taskService;
    @Autowired
    TaskRepository repository;
    @GetMapping("/task")// to get all the task
    public List<Task> getAllTasks(){
        List<Task> taskList= repository.findAll();
        return taskList;
    }
    //localhost:8080/students/1
    @GetMapping("/task/{id}") // find by id
    public Task getTask(@PathVariable Long id){
        Task task = repository.findById(id).get();
        return task;
    }
    // to addd new task
    @PostMapping("/task/add")
    //@ResponseStatus(code = HttpStatus.CREATED)// to change to status ok to created
    public void createTask(@RequestBody Task task){
        repository.save(task);
    }
    @PutMapping("/task/update/{id}")// for update task
    public Task updateTask(@PathVariable Long id){
        Task task =  repository.findById(id).get();
        task.setName("classroom");
        repository.save(task);
        return task;

    }
    @DeleteMapping("/task/delete/{id}")// for delete task
    public void deleteTask(@PathVariable Long id){
       Task task = repository.findById(id).get();
        repository.delete(task);


    }



}
