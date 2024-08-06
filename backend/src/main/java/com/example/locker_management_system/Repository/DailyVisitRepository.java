package com.example.locker_management_system.Repository;

import com.example.locker_management_system.Entity.LockerDailyVisit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyVisitRepository extends JpaRepository<LockerDailyVisit ,Long> {
}
