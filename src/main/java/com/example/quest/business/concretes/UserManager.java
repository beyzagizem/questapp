package com.example.quest.business.concretes;

import com.example.quest.business.abstracts.IUserService;
import com.example.quest.core.utilities.result.*;
import com.example.quest.dataAccess.abstracts.IUserRepository;
import com.example.quest.entities.concretes.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements IUserService {


    IUserRepository iUserRepository;

    public UserManager(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
    public Result add(User user) {

        iUserRepository.save(user);
        return new SuccessResult("Başarıyla eklendi");

    }

    @Override
    public DataResult<List<User>> getAll() {
//        if(true){
//            return new ErrorDataResult("Kullanıcılar listelenirken bir hata oluştu");
//        }
        return new SuccessDataResult<List<User>>(iUserRepository.findAll(),"Kullanıcılar listelendi");
    }
}
