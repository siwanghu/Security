package com.auditoryworks.service;

import com.auditoryworks.domain.Device;
import com.auditoryworks.domain.Message;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface DeviceService {
     Message bindDevice(String deviceId);
     Message relieveDevice(String deviceId);
     Page<Device> findPage(int pageNum,int pageSize);
     String user();
}
