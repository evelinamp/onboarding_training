package com.onboarding.inventory.service;

import com.onboarding.inventory.model.Device;

import java.util.List;
import java.util.Optional;

public interface IDeviceService {
    public List<Device> findAll();
    public Optional<Device> findById(String serialNumber);
    public Device save(Device device);
    public void deleteById(String id);
}
