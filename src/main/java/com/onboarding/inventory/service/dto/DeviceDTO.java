package com.onboarding.inventory.service.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.onboarding.inventory.model.Company;
import com.onboarding.inventory.model.Employee;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class DeviceDTO {

    @Id
    @Size(max = 255)
    @Column(name = "serial_number")
    private String serialNumber;

    @NotNull
    @Size(max = 255)
    private String name;

    @NotNull
    @Size(max = 255)
    private String type;

    private Company company;

    private Employee employee;

}
