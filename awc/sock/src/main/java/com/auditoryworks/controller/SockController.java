package com.auditoryworks.controller;

import com.auditoryworks.domain.MDMessage;
import com.auditoryworks.service.MDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SockController {
    @Autowired
    MDService mdService;

    @GetMapping("/all")
    @PreAuthorize("hasAnyAuthority('query')")
    public List<MDMessage> getAll(){
        return mdService.getAll();
    }
}