package com.onboarding.inventory.service.mapper;

import com.onboarding.inventory.model.Device;
import com.onboarding.inventory.service.dto.DeviceDTO;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper
public interface DeviceMapper {

    DeviceDTO toDeviceDTO(Device device);
    List<DeviceDTO> toDeviceDTOs(List<Device> devices);

    Device toDevice(DeviceDTO deviceDTO);
}
