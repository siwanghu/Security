package com.auditoryworks.repository;

import com.auditoryworks.domain.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    Device findByDeviceId(String deviceId);
    List<Device> findByUser(String user);
    void deleteByDeviceId(String deviceId);
}
