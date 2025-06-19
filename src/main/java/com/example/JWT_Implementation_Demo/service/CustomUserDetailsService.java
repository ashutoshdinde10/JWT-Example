package com.example.JWT_Implementation_Demo.service;

import com.example.JWT_Implementation_Demo.entity.Users;
import com.example.JWT_Implementation_Demo.exception.AppException;
import com.example.JWT_Implementation_Demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = usersRepository.findByUserEmail(email);
        if (user == null)
            throw new AppException("User Not Found with Email: " + email, "USER_NOT_FOUND", HttpStatus.NOT_FOUND);

        return new org.springframework.security.core.userdetails.User(user.getUserEmail(), user.getUserPassword(), List.of(new SimpleGrantedAuthority("ROLE_" + user.getUserRoles().getRoleName())));
    }
}
