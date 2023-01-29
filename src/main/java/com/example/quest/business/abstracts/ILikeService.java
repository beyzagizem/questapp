package com.example.quest.business.abstracts;

import com.example.quest.entities.concretes.Like;
import com.example.quest.entities.concretes.dtos.LikeRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface ILikeService {
    void add(LikeRequest likeRequest);
    List<Like> getAll();

    void deleteOneLike( int id);
}
