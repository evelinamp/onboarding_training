package com.onboarding.inventory.service;

import com.onboarding.inventory.model.Device;
import com.onboarding.inventory.repository.DeviceRepository;
import com.onboarding.inventory.service.dto.DeviceDTO;
import com.onboarding.inventory.service.mapper.DeviceMapper;
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
    private final DeviceMapper deviceMapper;

    @Override
    public List<DeviceDTO> findAll() {
        return deviceMapper.toDeviceDTOs(deviceRepository.findAll());
    }

    @Override
    public Optional<Device> findById(String serialNumber) {
        return deviceRepository.findById(serialNumber);
    }

    @Override
    public Device save(DeviceDTO deviceDTO) {
        return deviceRepository.save(deviceMapper.toDevice(deviceDTO));

    }
    @Override
    public void deleteById(String serialNumber){
        deviceRepository.deleteById(serialNumber);

    }
}
