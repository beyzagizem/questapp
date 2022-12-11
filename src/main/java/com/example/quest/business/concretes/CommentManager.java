package com.example.quest.business.concretes;

import com.example.quest.business.abstracts.ICommentService;
import com.example.quest.dataAccess.abstracts.ICommentRepository;
import com.example.quest.entities.concretes.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentManager implements ICommentService {

    ICommentRepository iCommentRepository;

    public CommentManager(ICommentRepository iCommentRepository) {
        this.iCommentRepository = iCommentRepository;
    }


    @Override
    public void add(Comment comment) {
        iCommentRepository.save(comment);

    }

    @Override
    public List<Comment> getAll() {
        return iCommentRepository.findAll();
    }
}
