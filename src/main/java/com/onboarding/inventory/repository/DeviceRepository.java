package com.onboarding.inventory.repository;

import com.onboarding.inventory.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, String> {
}
