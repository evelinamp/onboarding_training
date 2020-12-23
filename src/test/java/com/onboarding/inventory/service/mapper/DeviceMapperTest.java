package com.onboarding.inventory.service.mapper;

import com.onboarding.inventory.model.Company;
import com.onboarding.inventory.model.Device;
import com.onboarding.inventory.model.Employee;
import com.onboarding.inventory.service.dto.DeviceDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DeviceMapperTest {

    private final DeviceMapper deviceMapper = new DeviceMapperImpl();

    @Test
    void toDeviceDTO() {
        Device device = new Device();
        device.setSerialNumber("serial number");
        device.setName("name");
        device.setType("type");
        device.setCompany(new Company());
        device.setEmployee(new Employee());

        DeviceDTO deviceDTO = deviceMapper.toDeviceDTO(device);

        assertEquals(deviceDTO.getSerialNumber(), device.getSerialNumber());
        assertEquals(deviceDTO.getName(), device.getName());
        assertEquals(deviceDTO.getType(), device.getType());
        assertNull(deviceDTO.getCompany().getAddress());
        assertNull(deviceDTO.getEmployee().getEmail());

    }

    @Test
    void toDeviceDTO_null() {
        assertNull(deviceMapper.toDeviceDTO(null));
    }

}


