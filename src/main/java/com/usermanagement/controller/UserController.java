package com.usermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.usermanagement.dto.UserDTO;
import com.usermanagement.entity.User;
import com.usermanagement.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @return
     */
    @GetMapping("/user")
    public List<User> getAlUsers() {
        return userService.getAllUsers();
    }

    /**
     * 
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Integer id) {
        return userService.getUser(id);
    }

    /**
     * 
     * @param user
     */
    @PostMapping("/user")
    public void addUser(@RequestBody UserDTO user) {
        userService.addUser(user);
    }

    /**
     * 
     * @param user
     */
    @PutMapping("/users/{id}")
    public void updateUser(@RequestBody UserDTO user, @PathVariable Integer id) {
        userService.updateUser(user, id);
    }

    /**
     * 
     * @param id
     */
    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }

}
