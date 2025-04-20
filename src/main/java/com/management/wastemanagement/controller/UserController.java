package com.management.wastemanagement.controller;

import com.management.wastemanagement.models.Address;
import com.management.wastemanagement.models.User;
import com.management.wastemanagement.repository.UserRepository;
import com.management.wastemanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping(path = "/api/v1/user")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    // ✅ Endpoint to update a user's address
    @PutMapping("/{id}/address")
    public ResponseEntity<?> updateAddress(@PathVariable Long id, @RequestBody Address newAddress) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isEmpty()) return ResponseEntity.notFound().build();

        User user = userOpt.get();
        user.setHomeAddress(newAddress);
        userRepository.save(user);

        return ResponseEntity.ok("Address updated successfully.");
    }

    // ✅ Endpoint to get a user's address
    @GetMapping("/{id}/address")
    public ResponseEntity<Address> getAddress(@PathVariable Long id) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(userOpt.get().getHomeAddress());
    }
}
