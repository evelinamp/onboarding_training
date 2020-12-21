package com.onboarding.inventory.controller;

import com.onboarding.inventory.model.Device;
import com.onboarding.inventory.service.DeviceService;
import com.onboarding.inventory.service.dto.DeviceDTO;
import com.onboarding.inventory.service.mapper.DeviceMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor

@RestController
@RequestMapping("/devices")
public class DeviceController {

    @Autowired
    private final DeviceService deviceService;
    private final DeviceMapper deviceMapper;

    @GetMapping
    public ResponseEntity<List<DeviceDTO>> findDevices() {
        return ResponseEntity.ok(deviceMapper.toDeviceDTOs(deviceService.findAll()));
    }

    @PostMapping
    public ResponseEntity<DeviceDTO> create(@RequestBody DeviceDTO deviceDTO) {
        deviceService.save(deviceMapper.toDevice(deviceDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(deviceDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeviceDTO> findById(@PathVariable String serialNumber) {
        Optional<Device> device = deviceService.findById(serialNumber);

        return ResponseEntity.ok(deviceMapper.toDeviceDTO(device.get()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeviceDTO> update(@PathVariable String serialNumber, @RequestBody DeviceDTO deviceDTO) {
        Device device = deviceMapper.toDevice(deviceDTO);
        device.setSerialNumber(serialNumber);

        deviceService.save(device);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(deviceDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String serialNumber) {

        deviceService.deleteById(serialNumber);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
