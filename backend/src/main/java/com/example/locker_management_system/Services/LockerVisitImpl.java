package com.example.locker_management_system.Services;

import com.example.locker_management_system.Entity.LockerDailyVisit;
import com.example.locker_management_system.Repository.DailyVisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class LockerVisitImpl implements LockerVisitService {
    @Autowired
    private DailyVisitRepository lockerVisitRepository;

    @Override
    @Transactional
    public LockerDailyVisit saveLockerVisit(LockerDailyVisit lockerDailyVisit) {
        return lockerVisitRepository.save(lockerDailyVisit);
    }

    @Override

    public void deleteLockerVisitById(Long lockerId) {
        lockerVisitRepository.deleteById(lockerId);

    }

    @Override
    public LockerDailyVisit getLockerVisitById(Long lockerId) {
        return lockerVisitRepository.findById(lockerId).orElseThrow(()->
                new RuntimeException("Locker with lockerId " + lockerId + " not found"));
    }

    @Override
    public List<LockerDailyVisit> getAllLockerVisits() {
        return lockerVisitRepository.findAll();
    }
}
