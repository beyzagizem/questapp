package com.example.quest.business.abstracts;

import com.example.quest.entities.concretes.Post;
import com.example.quest.entities.concretes.dtos.PostRequest;

import java.util.List;

public interface IPostService {
    void add(PostRequest postrequest);
    List<Post> getAll();
}
