package com.example.quest.dataAccess.abstracts;

import com.example.quest.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
}
