package com.example.quest.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name ="description")
    private String description;

    @ManyToOne()
    @JoinColumn(name = "post_id")
    private  Post post;

    @ManyToOne()
    @JoinColumn(name= "user_id")
    private User user;

}
