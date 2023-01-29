package com.example.quest.business.concretes;

import com.example.quest.business.abstracts.IPostService;
import com.example.quest.core.utility.result.DataResult;
import com.example.quest.core.utility.result.SuccessDataResult;
import com.example.quest.dataAccess.abstracts.IPostRepository;
import com.example.quest.entities.concretes.Post;
import com.example.quest.entities.concretes.User;
import com.example.quest.entities.concretes.dtos.PostRequest;
import com.example.quest.entities.concretes.dtos.PostUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostManager implements IPostService {

    IPostRepository iPostRepository;

    public PostManager(IPostRepository iPostRepository) {
        this.iPostRepository = iPostRepository;
    }

    @Override
    public DataResult<PostRequest> add(PostRequest postrequest) {
        iPostRepository.save(convertFromPostRequestToPost(postrequest));
        return new SuccessDataResult<PostRequest>(postrequest,"Başarıyla eklendi");
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
    @Override
    public List<Post> getAll() {
        return iPostRepository.findAll();
    }

    @Override
    public Optional<Post> updateOnePost(int id, PostUpdateRequest newPost) {
        Optional<Post> post= iPostRepository.findById(id);
        if(post.isPresent()){
            Post existPost =post.get();
            existPost.setPostDescription (newPost.getPostDescription() );
            existPost.setPostTitle(newPost.getPostTitle());

            iPostRepository.save(existPost);
        }
        else {
            return null;
        }
        return post;
    }

    @Override
    public void deleteOnePost(int id) {
        iPostRepository.deleteById(id);

    }


}
