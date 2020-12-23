package com.onboarding.inventory.service;
import com.onboarding.inventory.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {

    public List<Employee> findAll();
    public Optional<Employee> findById(Integer id);
    public Employee save(Employee employee);
    public void deleteById(Integer id);

}
