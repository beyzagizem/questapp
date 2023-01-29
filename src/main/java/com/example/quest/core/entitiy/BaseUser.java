package com.example.quest.core.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "base_users")
@Inheritance(strategy = InheritanceType.JOINED)
public class BaseUser implements UserDetails{

        @Id
        @GeneratedValue
        private int id;

        @Column(name="email")
        private String email;
        @Column(name="password")
        private String password;



        @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
        private List<UserRole> userRoles;

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            Set<GrantedAuthority> authorities = new HashSet<>();
            if(userRoles!=null){
                for (int i=0;i<userRoles.size();i++){
                    authorities.add(new SimpleGrantedAuthority(userRoles.get(i).getRole().getName()));
                }
            }

            return authorities;
        }

        @Override
        public String getPassword() {
            return password;
        }

        @Override
        public String getUsername() {
            return email;
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }

