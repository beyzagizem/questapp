package com.example.quest.business.concretes;

import com.example.quest.dataAccess.abstracts.IUserRepository;
import com.example.quest.entities.concretes.User;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class JwtUserDetailManager implements UserDetailsService {

    IUserRepository iUserRepository;

    public JwtUserDetailManager(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return loadUserByUsername(username);
    }
}
