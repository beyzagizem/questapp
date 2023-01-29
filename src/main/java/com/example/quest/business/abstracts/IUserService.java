package com.example.quest.business.abstracts;

import com.example.quest.core.utility.result.DataResult;
import com.example.quest.core.utility.result.Result;
import com.example.quest.entities.concretes.Comment;
import com.example.quest.entities.concretes.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    DataResult<User> add(User user);

    DataResult<List<User>>  getAll();

    User getOneUser(int id);
    Optional<User>  updateOneUser(int id, User newUser);

    Result deleteOneUser(int id);



}
