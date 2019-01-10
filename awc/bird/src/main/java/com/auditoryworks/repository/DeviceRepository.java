package com.auditoryworks.repository;

import com.auditoryworks.domain.Device;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    Device findByDeviceId(String deviceId);
    List<Device> findByUser(String user);
    Page<Device> findByUser(String user, Pageable pageable);
    void deleteByDeviceId(String deviceId);
}
