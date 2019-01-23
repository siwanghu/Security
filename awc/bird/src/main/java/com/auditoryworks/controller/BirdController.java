package com.auditoryworks.controller;

import com.auditoryworks.domain.Device;
import com.auditoryworks.domain.Message;
import com.auditoryworks.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class BirdController {
    @Autowired
    DeviceService deviceService;

    @GetMapping("/ping")
    @PreAuthorize("hasAnyAuthority('query')")
    public String ping() {
        return "pong";
    }

    @GetMapping("/user")
    @PreAuthorize("hasAnyAuthority('query')")
    public String principal() {
        return deviceService.user();
    }

    @PutMapping("/bind")
    @PreAuthorize("hasAnyAuthority('query')")
    public Message bindDevice(String deviceId){
        return deviceService.bindDevice(deviceId);
    }

    @DeleteMapping("/relieve")
    @PreAuthorize("hasAnyAuthority('query')")
    public Message relieveDevice(String deviceId){
        return deviceService.relieveDevice(deviceId);
    }

    @GetMapping("/device")
    @PreAuthorize("hasAnyAuthority('query')")
    public Page<Device> findPage(int pagenum,int pagesize){
        return deviceService.findPage(pagenum,pagesize);
    }
}