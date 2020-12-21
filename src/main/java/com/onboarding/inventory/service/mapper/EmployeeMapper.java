package com.onboarding.inventory.service.mapper;

import com.onboarding.inventory.model.Employee;
import com.onboarding.inventory.service.dto.EmployeeDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    EmployeeDTO toEmployeeDTO(Employee employee);
    List<EmployeeDTO> toEmployeeDTOs(List<Employee> employees);

    Employee toEmployee(EmployeeDTO employeeDTO);
}
