package com.example.quest.entities.concretes.dtos;

import lombok.Data;

@Data
public class CommentRequest {

    private String description;
    private int postId;
    private  int userId;
}
