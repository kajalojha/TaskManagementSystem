package com.classroom.Classroom.Controllers;


import com.classroom.Classroom.Entities.Classroom;
import com.classroom.Classroom.Entities.Student;
import com.classroom.Classroom.Repositories.ClassroomRepository;
import com.classroom.Classroom.Repositories.StudentRepository;
import com.classroom.Classroom.Services.StudentService;
import com.classroom.Classroom.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController// used for  building RESTful web services. It simplifies the code,
// automatically converts return values to JSON/XML, and follows best practices for building APIs.

public class StudentController {
    private ClassroomRepository classroomRepository;
    private StudentService studentService;
    private TaskService taskService;
    @GetMapping("/classroom/{classroomId}/students")
    public ResponseEntity<List<Student>>getAllStudentsOfClassroom(@PathVariable(value="classroomId")Long classroomId){
        if(!classroomRepository.existsById(classroomId))
        {return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); }
        List<Student> students=studentService.getAllStudents( classroomId);
        return ResponseEntity.of((Optional.of(students)));
    }
  //get all the students
    //localhost:8080/students (show all the students)
  //The @GetMapping("/students") annotation in Spring Boot is used
    // to map HTTP GET requests to a specific URL path
    @Autowired
    StudentRepository repository;
    @GetMapping("/student")
    public List<Student> getAllStudents(){
        List<Student> studentsList = repository.findAll();
        return studentsList;
    }
    //localhost:8080/students/1
    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable Long id){
       Student student = repository.findById(id).get();
       return student;
    }
//    public ResponseEntity<String>createClassroom(@RequestBody Classroom Classroom){
//        try {
//            classroomService.addClassroom(Classroom);
//            return ResponseEntity.status(HttpStatus.CREATED).body("Classroom created Successfuly");
//        }catch (Exception e){
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to Create Classroom");
//        }
//
//    }
    // to addd new student
    @PostMapping("/student/add")
    //@ResponseStatus(code = HttpStatus.CREATED)// to change to status ok to created
    public void createStudent(@RequestBody Student student){
        repository.save(student);
    }


    @PutMapping("/student/update/{id}")
    public Student updateStudent(@PathVariable Long id){
      Student student =  repository.findById(id).get();
      student.setName("megha");
      repository.save(student);
      return student;

    }
    @DeleteMapping("/student/delete/{id}")
    public void deleteStudent(@PathVariable Long id){
        Student student = repository.findById(id).get();
        repository.delete(student);


    }



}
