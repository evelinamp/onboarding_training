package com.onboarding.inventory.service;

import com.onboarding.inventory.model.Device;
import com.onboarding.inventory.service.dto.DeviceDTO;

import java.util.List;
import java.util.Optional;

public interface IDeviceService {

    List<DeviceDTO> findAll();
    Optional<Device> findById(String serialNumber);
    Device save(DeviceDTO deviceDTO);
    void deleteById(String id);
}
