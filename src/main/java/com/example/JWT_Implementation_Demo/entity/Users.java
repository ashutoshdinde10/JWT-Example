package com.example.JWT_Implementation_Demo.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class Users {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private Long id;

        private String userName;
        private String userPassword;
        private String userEmail;
        private boolean isActive;

        @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        @JoinColumn(name = "role_id")
        private Roles userRoles;


    public Users() {
    }

    public Users(String userName, String userPassword, String userEmail, boolean isActive, Roles userRoles) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.isActive = isActive;
        this.userRoles = userRoles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Roles getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Roles userRoles) {
        this.userRoles = userRoles;
    }
}
