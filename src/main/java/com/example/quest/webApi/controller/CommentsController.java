package com.example.quest.webApi.controller;

import com.example.quest.business.abstracts.ICommentService;
import com.example.quest.entities.concretes.Comment;
import com.example.quest.entities.concretes.dtos.CommentRequest;
import jakarta.persistence.Entity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/comments/")
public class CommentsController {

    ICommentService iCommentService;


    public CommentsController(ICommentService iCommentService) {
        this.iCommentService = iCommentService;
    }
    @GetMapping("/")
    public List<Comment> getAll(){
        return this.iCommentService.getAll();
    }
    @PostMapping("/")
    public void add(@RequestBody CommentRequest commentRequest){
        this.iCommentService.add(commentRequest);
    }
}
