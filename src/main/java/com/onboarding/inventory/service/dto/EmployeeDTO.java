package com.onboarding.inventory.service.dto;

import com.onboarding.inventory.model.Company;
import com.onboarding.inventory.model.Device;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
public class EmployeeDTO {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;


    @NotNull
    @Size(max = 255)
    private String email;

    @NotNull
    @Size(max = 255)
    private String name;

    private Company company;

    private Set<Device> devices;


}
