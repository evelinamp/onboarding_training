package com.onboarding.inventory.controller;
import com.onboarding.inventory.model.Employee;
import com.onboarding.inventory.service.EmployeeService;

import com.onboarding.inventory.service.dto.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Slf4j
@RequiredArgsConstructor

@RestController
@RequestMapping("/employees")
public class EmployeeController {



    @Autowired
    private final EmployeeService employeeService;


    @GetMapping(produces = "application/json")
    public ResponseEntity<List<EmployeeDTO>> findEmployees() {


        return ResponseEntity.ok(employeeService.findAll());
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDTO> create(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.save(employeeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeDTO);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Integer id) {
        Optional<Employee> employee = employeeService.findById(id);

        return ResponseEntity.ok(employee.orElse(null));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Integer id, @Valid @RequestBody EmployeeDTO employeeDTO) {

        Employee employee = employeeService.findById(id).orElse(null);
        if (employee != null) {
            employeeDTO.setId(id);
            employeeService.save(employeeDTO);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(employeeDTO);
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(employeeDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {

        employeeService.deleteById(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }


}
