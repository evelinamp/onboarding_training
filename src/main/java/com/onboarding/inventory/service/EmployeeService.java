package com.onboarding.inventory.service;

import com.onboarding.inventory.model.Employee;
import com.onboarding.inventory.repository.EmployeeRepository;
import com.onboarding.inventory.service.dto.EmployeeDTO;
import com.onboarding.inventory.service.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmployeeService implements IEmployeeService{


    @Autowired
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeDTO> findAll() {
        return employeeMapper.toEmployeeDTOs(employeeRepository.findAll());
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee save(EmployeeDTO employeeDTO) {
        return employeeRepository.save(employeeMapper.toEmployee(employeeDTO));

    }
    @Override
    public void deleteById(Integer id){
        employeeRepository.deleteById(id);

    }


}
