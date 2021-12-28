package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void remove(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Iterable<Student> findAllByOrderByScoreDesc() {
        return studentRepository.findAllByOrderByScoreDesc();
    }

    @Override
    public Iterable<Student> findAllByOrderByScoreAsc() {
        return studentRepository.findAllByOrderByScoreAsc();
    }

    @Override
    public List<Student> findByNameContaining(String name) {
        return studentRepository.findByNameContaining(name);
    }

    @Override
    public Iterable<Student> findByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public Iterable<Student> findScore() {
        return studentRepository.findScore();
    }

    @Override
    public Iterable<Student> findAllByScoreLimit3() {
        return studentRepository.findAllByScoreLimit3();
    }

    @Override
    public Iterable<Student> findAllByAgeDESC() {
        return studentRepository.findAllByAgeDESC();
    }
}



