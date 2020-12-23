package com.onboarding.inventory.service;

import com.onboarding.inventory.model.Device;

import java.util.List;
import java.util.Optional;

public interface IDeviceService {

    List<Device> findAll();
    Optional<Device> findById(String serialNumber);
    Device save(Device device);
    void deleteById(String id);
}
