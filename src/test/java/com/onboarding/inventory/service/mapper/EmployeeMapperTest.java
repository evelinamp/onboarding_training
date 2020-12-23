package com.onboarding.inventory.service.mapper;

import com.onboarding.inventory.model.Company;
import com.onboarding.inventory.model.Employee;
import com.onboarding.inventory.service.dto.EmployeeDTO;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


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
        assertNotNull(employeeDTO.getCompany());
        assertNotNull(employeeDTO.getDevices());
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

    @Test
     void toEmployeeDTOs() {

        Employee employee = new Employee();
        employee.setId(1);

        List<Employee> employees = new ArrayList<Employee>() {{ add(employee); }};

        assertEquals(employeeMapper.toEmployeeDTOs(employees).size(), employees.size());
        assertEquals(employeeMapper.toEmployeeDTOs(employees).get(0).getId(), employee.getId());

    }

    @Test
    void toEmployeeDTOs_nullEmployees() {assertNull(employeeMapper.toEmployeeDTOs(null));}


    @Test
    void toEmployee() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(1);
        employeeDTO.setEmail("email@email.com");
        employeeDTO.setName("name");
        employeeDTO.setCompany(new Company());
        employeeDTO.setDevices(new HashSet<>());

        Employee employee = employeeMapper.toEmployee(employeeDTO);

        assertEquals(employee.getName(), employeeDTO.getName());
        assertEquals(employee.getId(), employeeDTO.getId());
        assertEquals(employee.getEmail(), employeeDTO.getEmail());
        assertNotNull(employee.getCompany());
        assertNotNull(employee.getDevices());
    }
}
