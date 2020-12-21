package com.onboarding.inventory.service;

import com.onboarding.inventory.model.Device;
import com.onboarding.inventory.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DeviceService implements IDeviceService {

    @Autowired
    private final DeviceRepository deviceRepository;

    @Override
    public List<Device> findAll() {
        return deviceRepository.findAll();
    }

    @Override
    public Optional<Device> findById(String serialNumber) {
        return deviceRepository.findById(serialNumber);
    }

    @Override
    public Device save(Device device) {
        return deviceRepository.save(device);

    }
    @Override
    public void deleteById(String serialNumber){
        deviceRepository.deleteById(serialNumber);

    }
}
