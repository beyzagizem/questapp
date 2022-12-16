package com.example.quest.business.abstracts;

import com.example.quest.entities.concretes.Comment;
import com.example.quest.entities.concretes.dtos.CommentRequest;

import java.util.List;

public interface ICommentService {
    void add(CommentRequest commentRequest);
    List<Comment> getAll();
}
