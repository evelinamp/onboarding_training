package com.onboarding.inventory.service.mapper;

import com.onboarding.inventory.model.Company;
import com.onboarding.inventory.model.Employee;
import com.onboarding.inventory.service.dto.EmployeeDTO;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


class EmployeeMapperTest {

    private final EmployeeMapper employeeMapper = new EmployeeMapperImpl();

    @Test
    void toEmployeeDTO() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setEmail("email@email.com");
        employee.setName("name");
        employee.setCompany(new Company());
        employee.setDevices(new HashSet<>());

        EmployeeDTO employeeDTO = employeeMapper.toEmployeeDTO(employee);

        assertEquals(employeeDTO.getName(), employee.getName());
        assertEquals(employeeDTO.getId(), employee.getId());
        assertEquals(employeeDTO.getEmail(), employee.getEmail());
        assertNull(employeeDTO.getCompany().getAddress());
        assertEquals(employeeDTO.getDevices().size(), 0);
    }

    @Test
    void toEmployeeDTO_nullEmployee() {
        assertNull(employeeMapper.toEmployeeDTO(null));
    }

    @Test
    void toEmployeeDTO_nullDevices() {
        Employee employee = new Employee();
        EmployeeDTO employeeDTO = employeeMapper.toEmployeeDTO(employee);
        assertNull(employeeDTO.getDevices());
    }


}
