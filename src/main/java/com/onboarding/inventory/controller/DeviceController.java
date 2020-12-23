package com.onboarding.inventory.controller;

import com.onboarding.inventory.model.Device;
import com.onboarding.inventory.service.DeviceService;
import com.onboarding.inventory.service.dto.DeviceDTO;


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


    @GetMapping
    public ResponseEntity<List<DeviceDTO>> findDevices() {
        return ResponseEntity.ok(deviceService.findAll());
    }

    @PostMapping
    public ResponseEntity<DeviceDTO> create(@RequestBody DeviceDTO deviceDTO) {
        deviceService.save(deviceDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(deviceDTO);
    }

    @GetMapping("/{serialNumber}")
    public ResponseEntity<Device> findById(@PathVariable String serialNumber) {
        Optional<Device> device = deviceService.findById(serialNumber);

        return ResponseEntity.ok(device.orElse(null));
    }

    @PutMapping("/{serialNumber}")
    public ResponseEntity update(@PathVariable String serialNumber, @RequestBody DeviceDTO deviceDTO) {
        Device device = deviceService.findById(serialNumber).orElse(null);
        if (device != null) {
            deviceDTO.setSerialNumber(serialNumber);
            deviceService.save(deviceDTO);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(deviceDTO);
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(deviceDTO);
    }

    @DeleteMapping("/{serialNumber}")
    public ResponseEntity delete(@PathVariable String serialNumber) {

        deviceService.deleteById(serialNumber);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
