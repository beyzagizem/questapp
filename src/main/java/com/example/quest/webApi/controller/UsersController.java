package com.example.quest.webApi.controller;

import com.example.quest.business.abstracts.IUserService;
import com.example.quest.core.utilities.result.DataResult;
import com.example.quest.core.utilities.result.Result;
import com.example.quest.entities.concretes.User;
import jakarta.validation.Valid;
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
    public DataResult<List<User>> getAll(){
        return this.iUserService.getAll();
    }
    @PostMapping("/")
    public Result add(@Valid @RequestBody User user){
       return (this.iUserService.add( user ));
    }

}
