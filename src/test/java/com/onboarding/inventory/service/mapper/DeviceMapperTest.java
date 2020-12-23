package com.onboarding.inventory.service.mapper;

import com.onboarding.inventory.model.Company;
import com.onboarding.inventory.model.Device;
import com.onboarding.inventory.model.Employee;
import com.onboarding.inventory.service.dto.DeviceDTO;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
    void toDeviceDTO_nullDevice() {assertNull(deviceMapper.toDeviceDTO(null)); }

    @Test
    void toDeviceDTOs() {

        Device device = new Device();
        device.setSerialNumber("123");

        List<Device> devices = new ArrayList<Device>() {{ add(device); }};

        assertEquals(deviceMapper.toDeviceDTOs(devices).size(), devices.size());
        assertEquals(deviceMapper.toDeviceDTOs(devices).get(0).getSerialNumber(), device.getSerialNumber());

    }

    @Test
    void toDeviceDTOs_nullDevices() {assertNull(deviceMapper.toDeviceDTOs(null)); }


    @Test
    void toDevice() {

        DeviceDTO deviceDTO = new DeviceDTO();
        deviceDTO.setSerialNumber("serial number");
        deviceDTO.setName("name");
        deviceDTO.setType("type");
        deviceDTO.setCompany(new Company());
        deviceDTO.setEmployee(new Employee());

        Device device = deviceMapper.toDevice(deviceDTO);

        assertEquals(device.getSerialNumber(), deviceDTO.getSerialNumber());
        assertEquals(device.getName(), deviceDTO.getName());
        assertEquals(device.getType(), deviceDTO.getType());
        assertNull(device.getCompany().getAddress());
        assertNull(device.getEmployee().getEmail());

    }
}


