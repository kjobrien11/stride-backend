package com.stride.stride.controller;

import com.stride.stride.dto.UserDTO;
import com.stride.stride.entity.User;
import com.stride.stride.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> index() {
        return ResponseEntity.ok().body(userService.getUsers());
    }
}
