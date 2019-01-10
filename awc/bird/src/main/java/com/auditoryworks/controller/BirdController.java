package com.auditoryworks.controller;

import com.auditoryworks.domain.Device;
import com.auditoryworks.service.DeviceService;
import com.auditoryworks.status.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class BirdController {
    @Autowired
    DeviceService deviceService;

    @GetMapping("/ping")
    @PreAuthorize("hasAnyAuthority('query')")
    public String query() {
        return "pong";
    }

    @GetMapping("/user")
    @PreAuthorize("hasAnyAuthority('query')")
    public String principal() {
        return deviceService.user();
    }

    @GetMapping("/bind")
    @PreAuthorize("hasAnyAuthority('query')")
    public Message bindDevice(String deviceId){
        return deviceService.bindDevice(deviceId);
    }

    @GetMapping("/relieve")
    @PreAuthorize("hasAnyAuthority('query')")
    public Message relieveDevice(String deviceId){
        return deviceService.relieveDevice(deviceId);
    }

    @GetMapping("/device")
    @PreAuthorize("hasAnyAuthority('query')")
    public List<Device> findDevices(){
        return deviceService.findAllDevice();
    }
}
