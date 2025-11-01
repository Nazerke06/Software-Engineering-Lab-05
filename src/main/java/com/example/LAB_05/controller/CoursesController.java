package com.example.LAB_05.controller;

import com.example.LAB_05.entity.Courses;
import com.example.LAB_05.repository.CourseRepository;
import com.example.LAB_05.services.CoursesServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/courses")
public class CoursesController {

    private final CourseRepository courseRepository;
    private final CoursesServices coursesServices;

    @GetMapping
    public ResponseEntity<?> getCoursesList() {
        List<Courses> courses = coursesServices.getCourses();

        if (courses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(courses, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getCourse(@PathVariable(value = "id") Long id) {
        Courses course = coursesServices.getCoursesList(id);

        if (Objects.isNull(course)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(course);
        }
    }

    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody Courses courses) {
        Courses createdCourse = coursesServices.addCourses(courses);
        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteCourses(@PathVariable(value = "id") Long id) {
        boolean deleted = coursesServices.deleteCourses(id);

        if (deleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
