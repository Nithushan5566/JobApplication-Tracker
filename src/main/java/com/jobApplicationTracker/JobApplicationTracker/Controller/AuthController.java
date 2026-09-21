package com.jobApplicationTracker.JobApplicationTracker.Controller;

import com.jobApplicationTracker.JobApplicationTracker.Model.User;
import com.jobApplicationTracker.JobApplicationTracker.Service.AuthService;
import com.jobApplicationTracker.JobApplicationTracker.Service.JwtService;
import com.jobApplicationTracker.JobApplicationTracker.response.AuthResponse;
import com.jobApplicationTracker.JobApplicationTracker.response.RegisterResponse;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthController(AuthService authService, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authService = authService;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public RegisterResponse register(@RequestBody User user) {


        User savedUser = authService.register(user);

        return new RegisterResponse(
                savedUser.getId(),
                savedUser.getUsername()
        );
    }
    @PostMapping("/login")
    public AuthResponse login(@RequestBody User user) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );

        String role = authentication.getAuthorities()
                .iterator()
                .next()
                .getAuthority()
                .replace("ROLE_", "");

        return new AuthResponse(
                jwtService.generateToken(user.getUsername(), role),
                user.getUsername(),
                role
        );
    }
}