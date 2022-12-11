package com.example.quest.business.abstracts;

import com.example.quest.entities.concretes.Comment;

import java.util.List;

public interface ICommentService {
    void add(Comment comment);
    List<Comment> getAll();
}
