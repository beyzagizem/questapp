package com.example.quest.business.concretes;

import com.example.quest.business.abstracts.IUserService;
import com.example.quest.dataAccess.abstracts.IUserRepository;
import com.example.quest.entities.concretes.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements IUserService {


    IUserRepository iUserRepository;

    public UserManager(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
    public void add(User user) {
        iUserRepository.save(user);

    }

    @Override
    public List<User> getAll() {
        return iUserRepository.findAll();
    }
}
