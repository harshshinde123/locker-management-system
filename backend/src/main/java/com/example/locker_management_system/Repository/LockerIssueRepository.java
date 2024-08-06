package com.example.locker_management_system.Repository;

import com.example.locker_management_system.Entity.LockerIssue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LockerIssueRepository extends JpaRepository<LockerIssue, Long> {

}
