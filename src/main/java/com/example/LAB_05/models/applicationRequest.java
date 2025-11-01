package com.example.LAB_05.models;


import com.example.LAB_05.entity.Courses;
import com.example.LAB_05.entity.Operators;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;



@Entity
@Table(name = "ApplicationList")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class applicationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;
    @Column(name = "Name", length = 200)
    private String userName;
    @Column(name = "Commentary", length = 200)
    private String commentary;
    @Column(name = "Phone", length = 200)
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Courses course;

    @ManyToMany
    @JoinTable(
            name = "application_request_operators",
            joinColumns = @JoinColumn(name = "request_id"),
            inverseJoinColumns = @JoinColumn(name = "operator_id")
    )
    private List<Operators> operators;

}
