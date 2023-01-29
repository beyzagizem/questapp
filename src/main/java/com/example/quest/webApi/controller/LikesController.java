package com.example.quest.webApi.controller;

import com.example.quest.business.abstracts.ILikeService;
import com.example.quest.entities.concretes.Like;
import com.example.quest.entities.concretes.User;
import com.example.quest.entities.concretes.dtos.LikeRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/likes/")
public class LikesController {

ILikeService iLikeService;

    public LikesController( ILikeService iLikeService) {
        this.iLikeService = iLikeService;
    }

    @GetMapping("/")
    public List<Like> getAll(){
        return this.iLikeService.getAll();
    }
    @PostMapping("/")
    public void add(@RequestBody LikeRequest likeRequest){
        this.iLikeService.add(likeRequest);
    }


    @DeleteMapping("/{id}")
    public void deleteOneLike(@PathVariable int id){
        iLikeService.deleteOneLike(id);
    }
}
