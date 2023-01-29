package com.example.quest.webApi.controller;

import com.example.quest.business.abstracts.IUserService;
import com.example.quest.core.dataAcces.BaseUserRepository;
import com.example.quest.core.entitiy.BaseUser;
import com.example.quest.core.utility.result.DataResult;
import com.example.quest.core.utility.result.ErrorDataResult;
import com.example.quest.core.utility.result.Result;
import com.example.quest.entities.concretes.User;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users")

public class UsersController {
    IUserService iUserService;
    BaseUserRepository iBaseUserRepo;

    public UsersController(IUserService iUserService,BaseUserRepository iBaseUserRepo) {
        this.iUserService = iUserService;
        this.iBaseUserRepo=iBaseUserRepo;
    }

    @GetMapping("/")

    public DataResult<List<User>> getAll() {
        return this.iUserService.getAll();
    }

    @PostMapping("/")
    public DataResult<User> add(@RequestBody @Valid User user) {
        return this.iUserService.add(user);
    }

    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable int id) {
        return this.iUserService.getOneUser(id);
    }

    @PutMapping("/{id}")
    public Optional<User> updateOneUser(@PathVariable int id, @RequestBody User newUser) {
        return this.iUserService.updateOneUser(id, newUser);
    }

    @DeleteMapping("/{id}")
    public Result deleteOneUser(@PathVariable int id) {
        return iUserService.deleteOneUser(id);
    }

    @GetMapping("/deneme")
    public List<BaseUser> getAllBaseUsers(){
        return iBaseUserRepo.findAll();
    }
}
