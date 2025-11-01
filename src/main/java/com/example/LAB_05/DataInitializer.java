package com.example.LAB_05;

import com.example.LAB_05.entity.Courses;
import com.example.LAB_05.repository.CourseRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    @Autowired
    private CourseRepository courseRepository;

    @PostConstruct
    public void init() {
        if (courseRepository.count() == 0) {
            courseRepository.save(new Courses(null, "Java Basics", "Intro course", 50000));
            courseRepository.save(new Courses(null, "Spring Boot", "Web backend course", 60000));
            courseRepository.save(new Courses(null, "Databases", "SQL and JDBC", 55000));
        }
    }
}
