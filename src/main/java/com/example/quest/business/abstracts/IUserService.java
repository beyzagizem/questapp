package com.example.quest.business.abstracts;

import com.example.quest.entities.concretes.User;

import java.util.List;

public interface IUserService {
    void add(User user);
      List<User> getAll();
}
