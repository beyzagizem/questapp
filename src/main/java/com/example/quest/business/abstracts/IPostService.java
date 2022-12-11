package com.example.quest.business.abstracts;

import com.example.quest.entities.concretes.Post;
import com.example.quest.entities.dtos.PostRequest;

import java.util.List;

public interface IPostService {
    void add(PostRequest postRequest);
    List<Post> getAll();
}
