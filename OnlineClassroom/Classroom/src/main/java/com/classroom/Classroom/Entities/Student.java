package com.classroom.Classroom.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "student")// manually give table name if we does not give table name then spring consider class name as a table name
public class Student {
    @Id // it means id should be unique
    @GeneratedValue(strategy= GenerationType.IDENTITY)//mysql provide id by itself we need not to provide .
    private Long studentId;
    //@Column(name = stu_name)if you want to explicitly provide the name
    @Column
    private String name;
    @Column
    private String password;
    @ManyToOne
    private Task task;

    public Student() {
    }

    public Student(Long studentId,String name,String password) {
        this.studentId = studentId;
        this.name = name ;
        this.password = password;
    }

    @ManyToMany(mappedBy = "enrolledStudents")
    private List<Classroom>classrooms;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", classrooms=" + classrooms +
                '}';
    }
}
