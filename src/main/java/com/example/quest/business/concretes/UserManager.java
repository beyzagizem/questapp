package com.example.quest.business.concretes;

import com.example.quest.business.abstracts.IUserService;
import com.example.quest.core.utility.result.*;
import com.example.quest.dataAccess.abstracts.IUserRepository;
import com.example.quest.entities.concretes.Comment;
import com.example.quest.entities.concretes.Post;
import com.example.quest.entities.concretes.User;
import com.example.quest.entities.concretes.dtos.CommentRequest;
import com.example.quest.entities.concretes.dtos.UserRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserManager implements IUserService {


    IUserRepository iUserRepository;

    public UserManager(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
    public DataResult<User> add(User user) {
        iUserRepository.save(user);
        return  new SuccessDataResult<User>(user,"Başarıyla eklendi");

    }


//    public User convertFromUserRequestToUser(UserRequest userRequest){
//
//        User user = new User();
//
//        user.setName(userRequest.ge );
//
//        return user;
//    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(iUserRepository.findAll(),"Kullanıcılar listelendi");
    }



    @Override
    public User getOneUser(int id) {
       return  iUserRepository.findById(id).orElse(null);
    }

    @Override
    public Optional <User> updateOneUser(int id, User newUser) {
        Optional<User> user= iUserRepository.findById(id);
        if(user.isPresent()){
            User existUser =user.get();
            existUser.setName(newUser.getName());
            existUser.setEmail(newUser.getEmail());
            existUser.setPassword(newUser.getPassword());
            iUserRepository.save(existUser);
        }
        else {
            return null;
        }
        return user;
    }

    @Override
    public Result deleteOneUser(int id) {
        try{
            iUserRepository.deleteById(id);
            return new SuccessResult("Başarıyla silindi");
        }catch (Error e){
            return new ErrorResult(e.getMessage());
        }

    }


}
