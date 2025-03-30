package com.example.crud_demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Student {

    //define fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    //define constructors

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


    //define getters/setters (annotated using lombok)

    //define toString() medthod (annotated using lombok)

}
