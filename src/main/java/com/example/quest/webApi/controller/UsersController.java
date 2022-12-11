package com.example.quest.webApi.controller;

import com.example.quest.business.abstracts.IUserService;
import com.example.quest.entities.concretes.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UsersController {
    IUserService iUserService;

    public UsersController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @GetMapping("/")

    public List<User> getAll(){
        return this.iUserService.getAll();
    }
    @PostMapping("/")
    public void add( @RequestBody User user){
        this.iUserService.add( user );
    }

}
