package com.example.quest.business.abstracts;

import com.example.quest.core.utility.result.DataResult;
import com.example.quest.entities.concretes.Post;
import com.example.quest.entities.concretes.dtos.PostRequest;
import com.example.quest.entities.concretes.dtos.PostUpdateRequest;

import java.util.List;
import java.util.Optional;

public interface IPostService {
    DataResult<PostRequest> add(PostRequest postrequest);
    List<Post> getAll();


    Optional<Post> updateOnePost(int id, PostUpdateRequest newPost);
    void deleteOnePost(int id);
}
