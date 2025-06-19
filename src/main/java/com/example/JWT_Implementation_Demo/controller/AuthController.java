package com.example.JWT_Implementation_Demo.controller;



import com.example.JWT_Implementation_Demo.dto.LoginRequestDTO;
import com.example.JWT_Implementation_Demo.dto.LoginResponseDTO;
import com.example.JWT_Implementation_Demo.dto.SignupRequest;
import com.example.JWT_Implementation_Demo.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    @Operation(summary = "Registering the User",
    description = "Users will need to add their  username, userEmail, password, roleName and register themselves")
    public ResponseEntity<String> signup(@Valid @RequestBody SignupRequest request) {
        return ResponseEntity.ok(authService.signup(request));
    }

    @PostMapping("/login")
    @Operation(summary = "Logging in and receiving JWT token",
    description = "Lo")
    public ResponseEntity<LoginResponseDTO> login(@Valid @RequestBody LoginRequestDTO request) {
        return ResponseEntity.ok(authService.login(request));
    }
}
