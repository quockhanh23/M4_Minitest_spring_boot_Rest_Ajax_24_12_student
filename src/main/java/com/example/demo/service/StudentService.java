package com.example.demo.service;


import com.example.demo.model.Student;

import java.util.List;

public interface StudentService extends GeneralService<Student> {
    Iterable<Student> findAllByOrderByScoreDesc();
    Iterable<Student> findAllByOrderByScoreAsc();
    List<Student> findByNameContaining(String name);
    Iterable<Student> findByName(String name);
    Iterable<Student> findScore();
    Iterable<Student> findAllByScoreLimit3();
    Iterable<Student> findAllByAgeDESC();
}
