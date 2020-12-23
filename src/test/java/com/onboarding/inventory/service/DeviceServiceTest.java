package com.onboarding.inventory.service;

import com.onboarding.inventory.model.Device;
import com.onboarding.inventory.model.Employee;
import com.onboarding.inventory.repository.DeviceRepository;
import com.onboarding.inventory.service.mapper.DeviceMapper;
import com.onboarding.inventory.service.mapper.DeviceMapperImpl;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class DeviceServiceTest {

    private final DeviceMapper deviceMapper = new DeviceMapperImpl();

    @Mock
    private DeviceRepository deviceRepository;

    private DeviceService deviceService;

    @BeforeEach
    void setUp() {deviceService = new DeviceService(deviceRepository, deviceMapper); }

    @Test
    void findAll() {
        Device device = new Device();
        device.setSerialNumber("123");
        when(deviceRepository.findAll())
                .thenReturn(new ArrayList<Device>(){{ add(device);}});

        assertEquals(deviceService.findAll().get(0).getSerialNumber(), "123");
    }

    @Test
    void findById() {
        Device device = new Device();
        device.setSerialNumber("123");
        when(deviceRepository.findById(any()))
                .thenReturn(Optional.of(device));
        assertEquals(deviceService.findById("123"), Optional.of(device));
    }

}
