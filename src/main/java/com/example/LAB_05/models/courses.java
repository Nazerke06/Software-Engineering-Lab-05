package com.example.LAB_05.models;


import com.example.LAB_05.entity.Courses;
import com.example.LAB_05.entity.Operators;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "CoursesList")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;
    @Column(name = "CourseName", length = 200)
    private String coursesName;
    @Column(name = "Description", length = 200)
    private String description;
    @Column(name = "price", length = 200)
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Courses course;

    @ManyToMany
    @JoinTable(
            name = "courses_operators",
            joinColumns = @JoinColumn(name = "request_id"),
            inverseJoinColumns = @JoinColumn(name = "operator_id")
    )
    private List<Operators> operators;

}
