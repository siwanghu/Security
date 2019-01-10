package com.auditoryworks.service;

import com.auditoryworks.status.Message;
import com.auditoryworks.domain.Device;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface DeviceService {
     Message bindDevice(String deviceId);
     Message relieveDevice(String deviceId);
     List<Device> findAllDevice();
     String user();
}
