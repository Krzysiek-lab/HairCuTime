package com.example.haircuttime.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "comments")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private Long id;
    @Column(name = "content")
    private String content;
    @Column(name = "grade")
    private Long grade;

}
