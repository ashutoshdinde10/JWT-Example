package com.example.JWT_Implementation_Demo.repository;



import com.example.JWT_Implementation_Demo.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, Long> {
    Roles findByRoleName(String roleName);
}