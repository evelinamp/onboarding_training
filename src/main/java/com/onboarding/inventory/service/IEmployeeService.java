package com.onboarding.inventory.service;
import com.onboarding.inventory.model.Employee;
import com.onboarding.inventory.service.dto.EmployeeDTO;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {

     List<EmployeeDTO> findAll();
     Optional<Employee> findById(Integer id);
     Employee save(EmployeeDTO employeeDTO);
     void deleteById(Integer id);

}
