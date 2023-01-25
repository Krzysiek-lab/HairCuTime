package com.example.haircuttime.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "comments")
@Data
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

    @ManyToMany
//    @JoinTable(name = "comments_services",
//            joinColumns = @JoinColumn(name = "comment_id"),
//            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;


}
