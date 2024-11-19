package com.hotelbooking.touroperatorservice.controller;

import com.hotelbooking.touroperatorservice.security.JwtTokenUtil;
import com.hotelbooking.touroperatorservice.model.User;
import com.hotelbooking.touroperatorservice.repository.UserRepository;
import com.hotelbooking.touroperatorservice.security.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping
    public ResponseEntity<String> createAuthenticationToken(@RequestParam String username, @RequestParam String password) {
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getPassword().equals(password)) {  // Здесь можно использовать более безопасный метод для проверки пароля
            String token = jwtTokenUtil.generateToken(username);
            return ResponseEntity.ok(token);
        }

        throw new RuntimeException("Invalid credentials");
    }
}
