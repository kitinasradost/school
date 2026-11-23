
package com.example.demo1;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "age", nullable = false, length = 100)
    private int age;

    @Column(name = "email", unique = true)
    private String email;



    @ManyToOne
    @JoinColumn(name = "group_id")
    protected Student() {
    }

    public Student(String name,int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;

    }



    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }





    @Override
    public String toString() {
        return "Student " +
                "id=" + id +
                ", name=" + name + '\'' +
                ", email=" + email + '\'' +
                ", courses=" + age;
    }
}
