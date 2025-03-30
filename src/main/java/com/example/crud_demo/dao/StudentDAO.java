package com.example.crud_demo.dao;

import com.example.crud_demo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student theStudent);

    void deleteStudent(int studentId);

    int deleteAll();

}
