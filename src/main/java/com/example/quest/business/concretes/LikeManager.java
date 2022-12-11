package com.example.quest.business.concretes;

import com.example.quest.business.abstracts.ILikeService;
import com.example.quest.dataAccess.abstracts.ILikeRepository;
import com.example.quest.entities.concretes.Like;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeManager implements ILikeService {

    ILikeRepository iLikeRepository;

    public LikeManager(ILikeRepository iLikeRepository) {
        this.iLikeRepository = iLikeRepository;
    }



    @Override
    public void add(Like like) {
        iLikeRepository.save(like);

    }

    @Override
    public List<Like> getAll() {
        return iLikeRepository.findAll();
    }
}
