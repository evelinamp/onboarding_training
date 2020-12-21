package com.onboarding.inventory.repository;

import com.onboarding.inventory.model.Admin;
import com.onboarding.inventory.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Admin findByEmail(String email);
    Admin findByName(String name);
}

