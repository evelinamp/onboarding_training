package com.onboarding.inventory.controller;

import com.onboarding.inventory.exception.ResourceNotFoundException;
import com.onboarding.inventory.model.Employee;
import com.onboarding.inventory.service.EmployeeService;
import com.onboarding.inventory.service.IEmployeeService;
import com.onboarding.inventory.service.dto.EmployeeDTO;
import com.onboarding.inventory.service.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Slf4j
@RequiredArgsConstructor

@RestController
@RequestMapping("/employees")
public class EmployeeController {



    @Autowired
    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;



    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> findEmployees() {
        return ResponseEntity.ok(employeeMapper.toEmployeeDTOs(employeeService.findAll()));
    }


    @PostMapping
    public ResponseEntity<EmployeeDTO> create(@Valid @RequestBody EmployeeDTO employeeDTO) {
        employeeService.save(employeeMapper.toEmployee(employeeDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> findById(@PathVariable Integer id) {

        Optional<Employee> employee = employeeService.findById(id);

        if(employee.isPresent()) {
            return new ResponseEntity<EmployeeDTO>(employeeMapper.toEmployeeDTO(employee.get()), HttpStatus.OK);
        }


        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Employee> findById(@PathVariable Integer id) {
//        Optional<Employee> employee = employeeService.findById(id);
//
//        return ResponseEntity.ok(employee.orElse(null));
//    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> update(@PathVariable Integer id, @Valid @RequestBody EmployeeDTO employeeDTO) {

        Employee employee = employeeMapper.toEmployee(employeeDTO);
        employee.setId(id);

        employeeService.save(employee);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(employeeDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        employeeService.deleteById(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }


}
