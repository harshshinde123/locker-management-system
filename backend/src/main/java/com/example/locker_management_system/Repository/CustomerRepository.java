package com.example.locker_management_system.Repository;

import com.example.locker_management_system.Entity.CustomerRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerRegistration, Long> {

}
