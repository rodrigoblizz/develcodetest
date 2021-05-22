package com.example.develcodetest.controller;

import com.example.develcodetest.exception.UserNotFoundException;
import com.example.develcodetest.model.User;
import com.example.develcodetest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/allusers")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/create")
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable(value = "id") Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User", "id", id));
    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody User userDetails) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User", "id", id));

        user.setName(userDetails.getName());
        user.setBirthdate(userDetails.getBirthdate());
        user.setPhoto(userDetails.getPhoto());

        User  updatedUser = userRepository.save(user);
        return updatedUser;
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User", "id", id));
        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }
}
