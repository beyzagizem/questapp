package com.example.quest.business.concretes;

import com.example.quest.business.abstracts.ICommentService;
import com.example.quest.dataAccess.abstracts.ICommentRepository;
import com.example.quest.entities.concretes.Comment;
import com.example.quest.entities.concretes.Post;
import com.example.quest.entities.concretes.User;
import com.example.quest.entities.concretes.dtos.CommentRequest;
import com.example.quest.entities.concretes.dtos.PostRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentManager implements ICommentService {

    ICommentRepository iCommentRepository;

    public CommentManager(ICommentRepository iCommentRepository) {
        this.iCommentRepository = iCommentRepository;
    }


    @Override
    public void add(CommentRequest commentRequest) {
        iCommentRepository.save(convertFromCommentRequestToComment(commentRequest));

    }
    public Comment convertFromCommentRequestToComment(CommentRequest commentRequest){
        Comment comment=new Comment();
        Post post = new Post();
        User user = new User();
        user.setId(commentRequest.getUserId());
        comment.setDescription(commentRequest.getDescription());
        post.setId(commentRequest.getPostId());
        comment.setUser(user);
        comment.setPost(post);
        return comment;
    }

    @Override
    public List<Comment> getAll() {
        return iCommentRepository.findAll();
    }

    @Override
    public Optional<Comment> updateOneComment(int id, Comment newComment) {
        Optional<Comment> comment= iCommentRepository.findById(id);
        if(comment.isPresent()){
            Comment existComment =comment.get();
            existComment.setDescription(newComment.getDescription());

            iCommentRepository.save(existComment);
        }
        else {
            return null;
        }
        return comment;
    }

    @Override
    public void deleteOneComment(int id) {
        iCommentRepository.deleteById(id);
    }
}
