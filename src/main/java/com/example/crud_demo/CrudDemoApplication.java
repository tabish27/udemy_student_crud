package com.example.crud_demo;

import com.example.crud_demo.dao.StudentDAO;
import com.example.crud_demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//            createStudent(studentDAO);
//            createMultipleStudents(studentDAO);
//            readStudent(studentDAO);
            fetchStudent(studentDAO);
//            queryForStudentsByLastName(studentDAO);
//            updateStudent(studentDAO);
//            deleteStudent(studentDAO);
//            deleteAll(studentDAO);
        };
    }

    private void deleteAll(StudentDAO studentDAO) {

        System.out.println("Deleting all student");
        int numRowsDeleted = studentDAO.deleteAll();
        System.out.println("Deleted rows count: " + numRowsDeleted);

    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 3;
        System.out.println("Deleting student with id: " + studentId);
        studentDAO.deleteStudent(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {
        //retrive student based on id
        int studentId = 1;
        System.out.println("Getting student with id: " + studentId);
        Student myStudent = studentDAO.findById(studentId);

        //change first name to scooby
        System.out.println("Updating student...");
        myStudent.setFirstName("John");

        //update the student
        studentDAO.update(myStudent);

        //display the updated student
        System.out.println("Updated Student " + myStudent);


    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {

        List<Student> theStudents = studentDAO.findByLastName("Duck");

        for (Student s : theStudents) {
            System.out.println(s);
        }

    }

    private void fetchStudent(StudentDAO studentDAO) {

        //get list of Students
        List<Student> theStudents = studentDAO.findAll();

        //display the list of students
        for (Student s : theStudents) {
            System.out.println(s);
        }

    }


    private void readStudent(StudentDAO studentDAO) {
        // create a student object
        System.out.println("Creating new student object...");
        Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");

        // save the student object
        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);

        // display id of the saved student
        System.out.println("Saved student. Generated id: " + tempStudent.getId());

        // retrieve student based on the id: primary key
        System.out.println("\nRetrieving student with id: " + tempStudent.getId());

        Student myStudent = studentDAO.findById(tempStudent.getId());

        System.out.println("Found the student: " + myStudent);
    }


    private void createMultipleStudents(StudentDAO studentDAO) {

        //create multiple student
        System.out.println("Creating 3 student object...");
        Student tempStudent1 = new Student("John", "Doe", "john@mymail.com");
        Student tempStudent2 = new Student("Marry", "Public", "marry@mymail.com");
        Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@mymail.com");

        //save the student object
        System.out.println("Saving the student...");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);


    }

    private void createStudent(StudentDAO studentDAO) {
        //create the student object
        System.out.println("Creating new object...");
        Student tempStudent = new Student("Paul", "Doe", "Paul@mymail.com");

        //save student object
        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);

        //display id of the saved student
        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }

}
