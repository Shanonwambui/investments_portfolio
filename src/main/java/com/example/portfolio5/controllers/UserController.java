package com.example.portfolio5.controllers;

import com.example.portfolio5.entities.User;
import com.example.portfolio5.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.Date;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.portfolio5.models.ApiResponse;
import org.springframework.http.HttpStatus;
import com.example.portfolio5.models.AppSummary;
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Get all users with ApiResponse
    @GetMapping
    public ResponseEntity<ApiResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        ApiResponse response = new ApiResponse(true, "Users retrieved successfully", users);
        return ResponseEntity.ok(response);
    }

    // Get user by ID with ApiResponse
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getUserById(@PathVariable UUID id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            ApiResponse response = new ApiResponse(true, "User retrieved successfully", user.get());
            return ResponseEntity.ok(response);
        } else {
            ApiResponse response = new ApiResponse(false, "User not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    // Create a new user with ApiResponse
    @PostMapping
    public ResponseEntity<ApiResponse> createUser(@RequestBody User user) {
        // Note: Ensure that the UUID is generated for the user before saving
        user.setId(UUID.randomUUID());
        User savedUser = userRepository.save(user);

        ApiResponse response = new ApiResponse(true, "User created successfully", savedUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Update existing user with ApiResponse
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateUser(@PathVariable UUID id, @RequestBody User updatedUser) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isEmpty()) {
            ApiResponse response = new ApiResponse(false, "User not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        User userToUpdate = existingUser.get();
        userToUpdate.setUsername(updatedUser.getUsername());
        userToUpdate.setEmail(updatedUser.getEmail());
        userToUpdate.setPassword(updatedUser.getPassword());

        User savedUser = userRepository.save(userToUpdate);

        ApiResponse response = new ApiResponse(true, "User updated successfully", savedUser);
        return ResponseEntity.ok(response);
    }

    // Delete user by ID with ApiResponse
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable UUID id) {
        if (!userRepository.existsById(id)) {
            ApiResponse response = new ApiResponse(false, "User not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        userRepository.deleteById(id);

        ApiResponse response = new ApiResponse(true, "User deleted successfully");
        return ResponseEntity.ok(response);
    }
}
