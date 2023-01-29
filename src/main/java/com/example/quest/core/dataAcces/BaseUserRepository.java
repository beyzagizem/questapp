package com.example.quest.core.dataAcces;

import com.example.quest.core.entitiy.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BaseUserRepository extends JpaRepository<BaseUser, Integer> {

    Optional<BaseUser> getByEmail(String email);
}
