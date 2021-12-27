package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double score;
    private int age;
    @ManyToOne
    @JoinColumn(name = "class_id")
    private Classes classes;

    public Student(Long id, String name, double score, int age, Classes classes) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.age = age;
        this.classes = classes;
    }

    public Student(String name, double score, int age, Classes classes) {
        this.name = name;
        this.score = score;
        this.age = age;
        this.classes = classes;
    }

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }
}
