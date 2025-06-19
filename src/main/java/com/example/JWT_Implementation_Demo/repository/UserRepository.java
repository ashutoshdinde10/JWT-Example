package com.example.JWT_Implementation_Demo.repository;

import com.example.JWT_Implementation_Demo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUserEmail(String email);

    boolean existsByUserEmail(String userEmail);
}
