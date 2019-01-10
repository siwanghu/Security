package com.auditoryworks.controller;

import com.auditoryworks.domain.Authority;
import com.auditoryworks.domain.Role;
import com.auditoryworks.domain.User;
import com.auditoryworks.repository.AuthorityRepository;
import com.auditoryworks.repository.RoleRepository;
import com.auditoryworks.service.UserService;
import com.auditoryworks.status.Message;
import com.google.common.collect.Sets;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Date;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public Principal user(Principal user){
        return user;
    }

    @PostMapping("/register")
    public Message register(User user ){
        return userService.registerUser(user);
    }
}