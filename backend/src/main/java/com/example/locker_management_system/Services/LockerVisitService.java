package com.example.locker_management_system.Services;

import com.example.locker_management_system.Entity.LockerDailyVisit;

import java.util.List;

public interface LockerVisitService {
    LockerDailyVisit saveLockerVisit(LockerDailyVisit lockerDailyVisit);
    void deleteLockerVisitById(Long Id);
    LockerDailyVisit getLockerVisitById(Long Id);
    List<LockerDailyVisit> getAllLockerVisits();
}
