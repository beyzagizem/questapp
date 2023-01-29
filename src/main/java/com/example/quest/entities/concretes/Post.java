package com.example.quest.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


    @Column(name="post_title")
    private  String postTitle;
    @Column(name="created_at")
    private Date createdAt= new Date();
    @Column(name="post_description")
    private  String postDescription;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private  User user;

    @JsonIgnore
    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    @JsonIgnore
    @OneToMany(mappedBy = "post")
    private  List<Like> likes;
}
