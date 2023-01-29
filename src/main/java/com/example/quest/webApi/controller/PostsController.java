package com.example.quest.webApi.controller;

import com.example.quest.business.abstracts.IPostService;
import com.example.quest.core.utility.result.DataResult;
import com.example.quest.entities.concretes.Post;
import com.example.quest.entities.concretes.User;
import com.example.quest.entities.concretes.dtos.PostRequest;
import com.example.quest.entities.concretes.dtos.PostUpdateRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public DataResult<PostRequest> add(@RequestBody PostRequest postrequest){
       return this.iPostService.add(postrequest);
    }

    @PutMapping("/{id}")
    public Optional<Post> updateOnePost(@PathVariable int id,@RequestBody PostUpdateRequest newPost) {
        //Optional<User> user=iUserService.updateOneUser(id,newUser);
        return this.iPostService.updateOnePost(id, newPost);
    }
    @DeleteMapping("/{id}")
    public void deleteOnePost(@PathVariable int id){
        iPostService.deleteOnePost(id);
    }
}

