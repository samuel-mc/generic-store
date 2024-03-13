package com.smedina.generic_store.web.controller;

import com.smedina.generic_store.service.UserService;
import com.smedina.generic_store.service.dto.user.LoginUserDTO;
import com.smedina.generic_store.service.dto.user.NewUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello from UserController";
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody NewUserDTO newUser) {
        try {
            return ResponseEntity.ok(userService.createUser(newUser));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginUserDTO loginUser) {
        try {
            return ResponseEntity.ok(userService.login(loginUser));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
