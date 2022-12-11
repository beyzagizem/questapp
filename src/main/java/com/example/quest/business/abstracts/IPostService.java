package com.example.quest.business.abstracts;

import com.example.quest.entities.concretes.Post;

import java.util.List;

public interface IPostService {
    void add(Post post);
    List<Post> getAll();
}
