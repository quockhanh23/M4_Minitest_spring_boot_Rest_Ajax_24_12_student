package com.example.demo.repository;

import com.example.demo.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
   Iterable<Student> findAllByOrderByScoreDesc();

   Iterable<Student> findAllByOrderByScoreAsc();

   List<Student> findByNameContaining(String name);

   Iterable<Student> findByName(String name);

   @Modifying
   @Query(value = "select * from student where score > 8", nativeQuery = true)
   Iterable<Student> findScore();

   @Modifying
   @Query(value = "select * from student order by score desc limit 3", nativeQuery = true)
   Iterable<Student> findAllByScoreLimit3();

   @Modifying
   @Query(value = "select * from student order by age DESC;", nativeQuery = true)
   Iterable<Student> findAllByAgeDESC();
}
