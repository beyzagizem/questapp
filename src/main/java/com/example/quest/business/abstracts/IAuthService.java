package com.example.quest.business.abstracts;

import com.example.quest.core.entitiy.BaseUser;
import com.example.quest.entities.concretes.Like;
import com.example.quest.entities.concretes.dtos.AuthRequest;
import com.example.quest.entities.concretes.dtos.RegisterRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IAuthService {


    String register(RegisterRequest request);

    String authenticate(AuthRequest request);
}
