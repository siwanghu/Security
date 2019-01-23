package com.auditoryworks.controller;

import com.auditoryworks.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubController {

    @Autowired
    RedisService redisService;

    @GetMapping("/user")
    @PreAuthorize("hasAnyAuthority('query')")
    public String user(){
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    }

    @GetMapping("/asr")
    @PreAuthorize("hasAnyAuthority('query')")
    public String asr(){
        return redisService.getAasrInRedis();
    }
}