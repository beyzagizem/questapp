package com.example.quest.dataAccess.abstracts;

import com.example.quest.core.entitiy.BaseUser;
import com.example.quest.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Integer> {


    Optional<User> getByEmail(String email);
}
