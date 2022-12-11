package com.example.quest.business.concretes;

import com.example.quest.business.abstracts.IPostService;
import com.example.quest.dataAccess.abstracts.IPostRepository;
import com.example.quest.entities.concretes.Post;
import com.example.quest.entities.concretes.User;
import com.example.quest.entities.dtos.PostRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostManager implements IPostService {

    IPostRepository iPostRepository;

    public PostManager(IPostRepository iPostRepository) {
        this.iPostRepository = iPostRepository;
    }

    @Override
    public void add( PostRequest postRequest) {
        iPostRepository.save(convertFromPostRequestToPost(postRequest));
    }

    @Override
    public List<Post> getAll() {
        return iPostRepository.findAll();
    }

    public Post convertFromPostRequestToPost(PostRequest postRequest){
        Post post = new Post();
        User user = new User();
        user.setId(postRequest.getUserId());
        post.setPostTitle(postRequest.getPostTitle());
        post.setPostDescription(postRequest.getPostDescription());
        post.setUser(user);
        return post;
        /*
        {
            "postTitle":"post title",
            "postDescription":"post description",
            "userId":1
        } ---- > convert to

        {
            "postTitle":"post title",
            "postDescription":"post description",
            "user":{
                "id":1
            }
        }
        * */

    }
}
