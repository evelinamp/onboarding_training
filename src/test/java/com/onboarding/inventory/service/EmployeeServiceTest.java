package com.onboarding.inventory.service;

import com.onboarding.inventory.model.Employee;
import com.onboarding.inventory.repository.EmployeeRepository;
import com.onboarding.inventory.service.mapper.EmployeeMapper;
import com.onboarding.inventory.service.mapper.EmployeeMapperImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class EmployeeServiceTest {

    private final EmployeeMapper employeeMapper = new EmployeeMapperImpl();

    @Mock
    private EmployeeRepository employeeRepository;

    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeService(employeeRepository, employeeMapper);
    }

    @Test
    void findAll() {
        Employee employee = new Employee();
        employee.setId(1);
        when(employeeRepository.findAll())
                .thenReturn(new ArrayList<Employee>() {{ add(employee); }});
        assertEquals(employeeService.findAll().get(0).getId(), 1);
    }

    @Test
    void findById() {
        Employee employee = new Employee();
        employee.setId(1);
        when(employeeRepository.findById(any()))
                .thenReturn(Optional.of(employee));
        assertEquals(employeeService.findById(1), Optional.of(employee));
    }


}
