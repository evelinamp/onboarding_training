package com.onboarding.inventory.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "company")
@Getter
@Setter
public class Company {

    @Id
    private Integer id;

    @NotNull
    @Size(max = 255)
    private String name;

    @NotNull
    @Size(max = 255)
    private String address;

    @JsonIgnore
    @OneToOne(mappedBy = "company")
    private Admin admin;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private Set<Employee> employees;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private Set<Device> devices;




}
