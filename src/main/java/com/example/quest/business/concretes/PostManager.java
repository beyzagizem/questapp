package com.example.quest.business.concretes;

import com.example.quest.business.abstracts.IPostService;
import com.example.quest.dataAccess.abstracts.IPostRepository;
import com.example.quest.entities.concretes.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostManager implements IPostService {

    IPostRepository iPostRepository;

    public PostManager(IPostRepository iPostRepository) {
        this.iPostRepository = iPostRepository;
    }

    @Override
    public void add( Post post) {
        iPostRepository.save(post);


    }

    @Override
    public List<Post> getAll() {
        return iPostRepository.findAll();
    }
}
