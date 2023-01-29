package com.example.quest.business.abstracts;

import com.example.quest.entities.concretes.Comment;
import com.example.quest.entities.concretes.dtos.CommentRequest;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface ICommentService {
    void add(CommentRequest commentRequest);
    List<Comment> getAll();

    Optional<Comment> updateOneComment(int id, Comment newComment);
    void deleteOneComment( int id);
}
