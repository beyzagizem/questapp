package com.example.quest.business.abstracts;

import com.example.quest.entities.concretes.Like;

import java.util.List;

public interface ILikeService {
    void add(Like like);
    List<Like> getAll();
}
