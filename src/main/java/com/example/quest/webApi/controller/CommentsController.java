package com.example.quest.webApi.controller;

import com.example.quest.business.abstracts.ICommentService;
import com.example.quest.entities.concretes.Comment;
import com.example.quest.entities.concretes.User;
import com.example.quest.entities.concretes.dtos.CommentRequest;
import jakarta.persistence.Entity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/comments/")
public class CommentsController {

    ICommentService iCommentService;


    public CommentsController(ICommentService iCommentService) {
        this.iCommentService = iCommentService;
    }

    @GetMapping("/")
    public List<Comment> getAll() {
        return this.iCommentService.getAll();
    }

    @PostMapping("/")
    public void add(@RequestBody CommentRequest commentRequest) {
        this.iCommentService.add(commentRequest);
    }

    @PutMapping("/{id}")
    public Optional<Comment> updateOneComment(@PathVariable int id, @RequestBody Comment newComment) {
        //Optional<User> user=iUserService.updateOneUser(id,newUser);
        return this.iCommentService.updateOneComment(id, newComment);
    }

    @DeleteMapping("/{id}")
    public void deleteOneComment(@PathVariable int id) {
        iCommentService.deleteOneComment(id);
    }

}
