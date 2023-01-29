package com.example.quest.entities.concretes;


import com.example.quest.core.entitiy.BaseUser;
import com.example.quest.core.utility.customvalidation.ContactNumberConstraint;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Entity
@Table(name = "users")
@PrimaryKeyJoinColumn(name="id")
public class User extends BaseUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

    @ContactNumberConstraint
    @Column(name="phone")
    private String phone;

    @JsonIgnore
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<Post> posts;

    @JsonIgnore
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<Like> likes;
    @JsonIgnore
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private  List<Comment> comments;
}
