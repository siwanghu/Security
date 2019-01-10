package com.auditoryworks.service;

import com.auditoryworks.status.Message;
import com.auditoryworks.domain.Device;
import com.auditoryworks.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class DeviceServiceImpl implements DeviceService{
    @Autowired
    DeviceRepository deviceRepository;

    @Override
    public Message bindDevice(String deviceId) {
        Device device=deviceRepository.findByDeviceId(deviceId);
        if(device!=null){
            return new Message(false,"当前设备已被绑定",new Date().getTime());
        }else{
            Device bind=new Device();
            bind.setDeviceId(deviceId);
            bind.setUser(user());
            deviceRepository.save(bind);
            return new Message(true,"设备绑定成功",new Date().getTime());
        }
    }

    @Override
    public Message relieveDevice(String deviceId) {
        Device device=deviceRepository.findByDeviceId(deviceId);
        if(device==null){
            return new Message(false,"当前设备没有绑定任何主人，不可以解绑",new Date().getTime());
        }else{
            if(!device.getUser().equals(user())){
                return new Message(false,"你不是该设备的主人，无法解绑",new Date().getTime());
            }else{
                deviceRepository.deleteByDeviceId(deviceId);
                return new Message(true,"设备解绑成功",new Date().getTime());
            }
        }
    }

    @Override
    public List<Device> findAllDevice() {
        return deviceRepository.findByUser(user());
    }

    @Override
    public String user() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    }
}