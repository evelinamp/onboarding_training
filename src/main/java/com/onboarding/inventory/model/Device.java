package com.onboarding.inventory.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "device")
@Getter
@Setter
public class Device {

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

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn( name = "employee_id")
    @JsonBackReference
    private Employee employee;




}
