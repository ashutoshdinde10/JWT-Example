package com.example.JWT_Implementation_Demo.service;


import com.example.JWT_Implementation_Demo.dto.LoginRequestDTO;
import com.example.JWT_Implementation_Demo.dto.LoginResponseDTO;
import com.example.JWT_Implementation_Demo.dto.SignupRequest;
import com.example.JWT_Implementation_Demo.entity.Roles;
import com.example.JWT_Implementation_Demo.entity.Users;
import com.example.JWT_Implementation_Demo.repository.RolesRepository;
import com.example.JWT_Implementation_Demo.repository.UserRepository;
import com.example.JWT_Implementation_Demo.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class  AuthService {

    @Autowired
    private UserRepository usersRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtil jwtUtil;

    public String signup(SignupRequest request) {
        Roles role = rolesRepository.findByRoleName(request.getRoleName());
        if (role == null) throw new RuntimeException("Invalid role");

        Users user = new Users();
        user.setUserName(request.getUsername());
        user.setUserEmail(request.getUserEmail());
        user.setUserPassword("{bcrypt}"+new BCryptPasswordEncoder().encode(request.getPassword()));
        user.setUserRoles(role);
        user.setActive(true);

        usersRepository.save(user);
        return "User registered successfully!";
    }

    public LoginResponseDTO login(LoginRequestDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUserEmail(), request.getPassword())
        );

        Users user = usersRepository.findByUserEmail(request.getUserEmail());
        String token = jwtUtil.generateToken(user.getUserEmail());

        LoginResponseDTO response = new LoginResponseDTO();
        response.setToken(token);
        response.setRole(user.getUserRoles().getRoleName());
        response.setEmail(user.getUserEmail());
        response.setOperations(new ArrayList<>(user.getUserRoles().getOperations()));
        response.setMessage("Authentication Successful");
        return response;
    }
}
