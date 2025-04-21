package com.example.jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jdbc.model.User;
import com.example.jdbc.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public String addUser(@RequestBody User user) {
        int result = userService.addUser(user);
        return result > 0 ? "User added successfully" : "Failed to add user";
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User user) {
        int result = userService.updateUser(id, user);
        return result > 0 ? "User updated successfully" : "Failed to update user";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        int result = userService.deleteUser(id);
        return result > 0 ? "User deleted successfully" : "Failed to delete user";
    }

}
