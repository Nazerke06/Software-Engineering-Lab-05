package com.example.LAB_05.services;
import com.example.LAB_05.entity.Courses;
import com.example.LAB_05.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CoursesServices {


        private final CourseRepository courseRepository;

        public List<Courses> getCourses(){
            List<Courses> courses = courseRepository.findAll();
            return courses;
        }

        public Courses addCourses(Courses courses){
            Courses createdCourses = courseRepository.save(courses);
            return createdCourses;
        }

        public Courses getCoursesList(Long id){
            Courses courses = courseRepository.findById(id).orElse(null);
            return courses;
        }

        public boolean deleteCourses(Long id){
            Courses checkCourses = getCoursesList(id);

            if(Objects.isNull(checkCourses)){
                return false;
            }
            courseRepository.deleteById(id);

            return true;
        }
    }
