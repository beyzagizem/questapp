package com.example.quest.business.concretes;

import com.example.quest.business.abstracts.IAuthService;
import com.example.quest.core.dataAcces.BaseUserRepository;
import com.example.quest.core.entitiy.BaseUser;
import com.example.quest.core.security.JwtService;
import com.example.quest.dataAccess.abstracts.IUserRepository;
import com.example.quest.entities.concretes.User;
import com.example.quest.entities.concretes.dtos.AuthRequest;
import com.example.quest.entities.concretes.dtos.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthManager implements IAuthService {

        private final IUserRepository repository;
        private final PasswordEncoder passwordEncoder;
        private final JwtService jwtService;
        private final AuthenticationManager authenticationManager;

        public String register(RegisterRequest request ) {
            User user = new User();
            user.setEmail(request.getEmail());
            user.setPhone(request.getPhoneNumber());
            user.setPassword(passwordEncoder.encode(request.getPassword()));

            repository.save(user);
            var jwtToken = jwtService.generateToken(user);
            return jwtToken;
        }

        public String authenticate(AuthRequest request) {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
            User user = repository.getByEmail(request.getEmail())
                    .orElseThrow();
            var jwtToken = jwtService.generateToken(user);
            return jwtToken;
        }
    }


