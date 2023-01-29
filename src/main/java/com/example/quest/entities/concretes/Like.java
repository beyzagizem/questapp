package com.example.quest.entities.concretes;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private  int id;

    @ManyToOne()
    @JoinColumn(name = "post_id")
    private  Post post;

    @ManyToOne()
    @JoinColumn(name="user_id")
    private  User user;
}
