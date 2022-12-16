package com.example.quest.webApi.controller;

import com.example.quest.business.abstracts.IPostService;
import com.example.quest.entities.concretes.Post;
import com.example.quest.entities.concretes.dtos.PostRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/posts/")
public class PostsController {
    IPostService iPostService;

    public PostsController(IPostService iPostService) {
        this.iPostService = iPostService;
    }

    @GetMapping("/")
    public List<Post> getAll(){
        return this.iPostService.getAll();
    }
    @PostMapping("/")
    public void add(@RequestBody PostRequest postrequest){
        this.iPostService.add(postrequest);
    }
}
