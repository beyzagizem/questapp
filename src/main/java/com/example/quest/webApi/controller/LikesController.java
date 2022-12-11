package com.example.quest.webApi.controller;

import com.example.quest.business.abstracts.ILikeService;
import com.example.quest.entities.concretes.Like;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void add(@RequestBody Like like){
        this.iLikeService.add(like);
    }
}
