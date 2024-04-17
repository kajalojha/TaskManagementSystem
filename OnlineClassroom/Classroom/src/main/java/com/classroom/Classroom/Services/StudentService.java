package com.classroom.Classroom.Services;

import com.classroom.Classroom.Entities.Classroom;
import com.classroom.Classroom.Entities.Student;
import com.classroom.Classroom.Entities.Task;
import com.classroom.Classroom.Repositories.ClassroomRepository;
import com.classroom.Classroom.Repositories.StudentRepository;
import com.classroom.Classroom.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
   private StudentRepository studentRepository;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private ClassroomRepository classroomRepository;
    public Student registerStudent(Student student){
     return studentRepository.save(student);
    }
    public ResponseEntity<List<Task>>FetchAllTasksByUserId(Long id){
        List<Task> store=  taskRepository.findByStudentStudentId(id);
        return ResponseEntity.ok(store); }
    public List<Student>getAllStudents(Long classroomId){
        List<Student> students=studentRepository.findByClassrooms_ClassroomId(classroomId);
        return students;
    }
    

}
