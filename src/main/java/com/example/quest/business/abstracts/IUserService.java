package com.example.quest.business.abstracts;

import com.example.quest.core.utilities.result.DataResult;
import com.example.quest.core.utilities.result.Result;
import com.example.quest.entities.concretes.User;

import java.util.List;

public interface IUserService {
    Result add(User user);
    DataResult<List<User>> getAll();
}
