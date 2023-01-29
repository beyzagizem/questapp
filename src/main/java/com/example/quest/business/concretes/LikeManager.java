package com.example.quest.business.concretes;

import com.example.quest.business.abstracts.ILikeService;
import com.example.quest.dataAccess.abstracts.ILikeRepository;
import com.example.quest.entities.concretes.Comment;
import com.example.quest.entities.concretes.Like;
import com.example.quest.entities.concretes.Post;
import com.example.quest.entities.concretes.User;
import com.example.quest.entities.concretes.dtos.LikeRequest;
import com.example.quest.entities.concretes.dtos.PostRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeManager implements ILikeService {

    ILikeRepository iLikeRepository;

    public LikeManager(ILikeRepository iLikeRepository) {
        this.iLikeRepository = iLikeRepository;
    }



    @Override
    public void add(LikeRequest likeRequest) {
        iLikeRepository.save(convertFromLikeRequestToLike(likeRequest));

    }
    public Like convertFromLikeRequestToLike(LikeRequest likeRequest){
        Like like = new Like();
        Post post=new Post();
        User user=new User();
        user.setId(likeRequest.getUserId());
        like.setId  (likeRequest.getId());
        post.setId (likeRequest.getPostId());

        return like;
    }

    @Override
    public List<Like> getAll() {
        return iLikeRepository.findAll();
    }



    @Override
    public void deleteOneLike(int id) {
        iLikeRepository.deleteById(id);
    }
}
