package com.usermanagement.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    @PutMapping("/user/{id}")
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

    @PostMapping("/user/uploadUsers")
    public void uploadUsers(@RequestParam("file") MultipartFile usersFile) throws JsonParseException, JsonMappingException, IOException {
        // getInputStream performance effective as it continues to stream the data
        // continuosly from the file
        List<UserDTO> users = Arrays.asList(new ObjectMapper().readValue(usersFile.getInputStream(), UserDTO[].class));
        // List<UserDTO> users = Arrays.asList(new
        // ObjectMapper().readValue(usersFile.getBytes(), UserDTO[].class));
        userService.uploadUsers(users);

    }

}
