package com.example.lab02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import java.util.List;
import java.util.ArrayList;
import com.example.demo.Student;

@SpringBootApplication
@RestController
@RequestMapping("/api")

public class Lab02Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab02Application.class, args);
    }

    // Bài 1: Hello
    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring Boot API";
    }

    // Bài 2: API nhận tham số
    @GetMapping("/student/{id}")
    public String getStudent(@PathVariable int id) {
        return "Sinh viên có mã: " + id;
    }

    // Bài 3: API nhận tham số
    @GetMapping(value = "/student", params = "name")
    public String greet(@RequestParam String name) {
        return "Xin chào " + name;
    }

    @GetMapping("/searchStudent")
    public String searchStudent(@RequestParam String name, @RequestParam(defaultValue = "1") int age) {
        return "Tên = " + name + ", tuổi = " + age;
    }

    // Bài 4A: trả về JSON Object
    @GetMapping("/students")
    public Student getStudent() {
        return new Student(1, "Nguyễn Văn A", 20);
    }

    // Bài 4B: trả về list
    @GetMapping("/studentall")
    public List<Student> getStudents() {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "A", 20));
        list.add(new Student(2, "B", 21));
        return list;
    }

    // Bài 5: dữ liệu nằm trong Header
    @GetMapping("/getstudent")
    public String getStudents(@RequestHeader("Authorization") String authorization) {
        return "Authorization = " + authorization;
    }
}
