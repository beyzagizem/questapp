package com.example.quest.business.concretes;

import com.example.quest.business.abstracts.IPostService;
import com.example.quest.dataAccess.abstracts.IPostRepository;
import com.example.quest.entities.concretes.Post;
import com.example.quest.entities.concretes.User;
import com.example.quest.entities.concretes.dtos.PostRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostManager implements IPostService {

    IPostRepository iPostRepository;

    public PostManager(IPostRepository iPostRepository) {
        this.iPostRepository = iPostRepository;
    }

    @Override
    public void add(PostRequest postrequest) {
        iPostRepository.save(convertFromPostRequestToPost(postrequest));
    }

    @Override
    public List<Post> getAll() {
        return iPostRepository.findAll();
    }
    public Post convertFromPostRequestToPost(PostRequest postrequest){
        Post post = new Post();
        User user = new User();
        user.setId(postrequest.getUserId());
        post.setPostTitle(postrequest.getPostTitle());
        post.setPostDescription(postrequest.getPostDescription());
        post.setUser(user);
        return post;
    }

}
