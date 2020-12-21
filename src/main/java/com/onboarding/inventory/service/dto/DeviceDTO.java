package com.onboarding.inventory.service.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.onboarding.inventory.model.Company;
import com.onboarding.inventory.model.Employee;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class DeviceDTO {

    @NotNull
    @Size(max = 255)
    private String name;

    @NotNull
    @Size(max = 255)
    private String type;

    private Company company;

    private Employee employee;

}
