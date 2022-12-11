package com.example.quest.entities.dtos;

import lombok.Data;

@Data
public class PostRequest {
    private String postTitle;
    private String postDescription;
    private int userId;

}
