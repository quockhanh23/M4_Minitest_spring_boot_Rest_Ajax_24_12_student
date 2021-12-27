package com.example.demo.controller;

import com.example.demo.service.ClassesServiceImpl;
import com.example.demo.service.StudentServiceImpl;
import com.example.demo.model.Classes;
import com.example.demo.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;
    @Autowired
    private ClassesServiceImpl classesService;

    @ModelAttribute("classes")
    public Iterable<Classes> classes() {
        return classesService.findAll();
    }

    @GetMapping("")
    public String showList(HttpServletResponse response, @CookieValue(value = "counter", defaultValue = "0") Long counter, Model model, String search) {
        counter++;
        Cookie cookie = new Cookie("counter", counter.toString());
        cookie.setMaxAge(20);
        response.addCookie(cookie);
        Iterable<Student> students;
        if (search == null) {
            students = studentService.findAll();
        } else {
            students = studentService.findByNameContaining(search);
        }
        model.addAttribute("list", students);
        model.addAttribute("cookie", cookie);
        return "/list";
    }

    @GetMapping("/sort")
    public String showSort1(Model model, String search) {
        Iterable<Student> students;
        if (search == null) {
            students = studentService.findAllByOrderByScoreDesc();

        } else {
            students = studentService.findByNameContaining(search);
        }
        model.addAttribute("list", students);
        return "/list";
    }

    @GetMapping("/sort3")
    public String showSort3(Model model, String search) {
        Iterable<Student> students;
        if (search == null) {
            students = studentService.findScore();
        } else {
            students = studentService.findByNameContaining(search);
        }
        model.addAttribute("list", students);
        return "/list";
    }

    @GetMapping("/sort4")
    public String showSort4(Model model, String search) {
        Iterable<Student> students;
        if (search == null) {
            students = studentService.findAllByScoreLimit3();
        } else {
            students = studentService.findByNameContaining(search);
        }
        model.addAttribute("list", students);
        return "/list";
    }

    @GetMapping("/sort2")
    public String showSort2(Model model, String search) {
        Iterable<Student> students;
        if (search == null) {
            students = studentService.findAllByOrderByScoreAsc();
        } else {
            students = studentService.findByNameContaining(search);
        }
        model.addAttribute("list", students);
        return "/list";
    }

    @GetMapping("/edit-student/{id}")
    public String showEdit(@PathVariable Long id, Model model) {
        Optional<Student> student = studentService.findById(id);
        Student student1 = student.get();
        model.addAttribute("edit", student1);
        return "/edit";
    }

    @PostMapping("/edit")
    public String edit(Student student) {
        studentService.save(student);
        return "redirect:/student";
    }
}
