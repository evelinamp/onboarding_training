package com.onboarding.inventory.service;
import com.onboarding.inventory.model.Employee;
import com.onboarding.inventory.service.dto.EmployeeDTO;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {

    public List<EmployeeDTO> findAll();
    public Optional<Employee> findById(Integer id);
    public Employee save(EmployeeDTO employeeDTO);
    public void deleteById(Integer id);

}
