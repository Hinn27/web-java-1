package com.example.buoi_1_170826;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.ArrayList;

@SpringBootApplication
@RestController

public class Buoi1170826Application {

    public static void main(String[] args) {
        SpringApplication.run(Buoi1170826Application.class, args);
    }

    // Trang mặc định
    @GetMapping("/")
    public String home() {
        return "Ứng dụng Spring Boot đang chạy";
    }

    // Bài 1: Hello
    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring Boot API";
    }

    // Bài 2: API nhận tham số
    @GetMapping("/greet")
    public String greet(@RequestParam String name) {
        return "Xin chào " + name;
    }

    @GetMapping("/students/search")
    public String search(@RequestParam String keyword, @RequestParam(defaultValue = "1") int page) {
        return "keyword=" + keyword + ", page=" + page;
    }

    // Bài 3: API với Path Variable
    @GetMapping("/students/{id}")
    public String getStudent(@PathVariable int id) {
        return "Sinh viên có mã: " + id;
    }

    // Bài 4: trả về JSON Object
    // Model
    public static class Student {
        private int id;
        private String name;
        private int age;

        // constructor
        public Student(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        // getter và setter
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    // Controller
    @GetMapping("/student")
    public Student getStudent() {
        return new Student(1, "Nguyễn Văn A", 20);
    }

    // Bài 5: trả về list
    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "A", 20));
        list.add(new Student(2, "B", 21));
        return list;
    }
}