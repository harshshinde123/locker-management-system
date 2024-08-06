package com.example.locker_management_system.Controller;

import com.example.locker_management_system.Entity.LockerDailyVisit;
import com.example.locker_management_system.Services.LockerVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dailyVisit")
public class DailyVisitComtroller {
    @Autowired
    private LockerVisitService lockerVisitService;

    @PostMapping("/add")
    public LockerDailyVisit saveLockerVisit(LockerDailyVisit lockerDailyVisit) {
        return lockerVisitService.saveLockerVisit(lockerDailyVisit);
    }

   @GetMapping("/getAll")
    public List<LockerDailyVisit> getAllLockerVisits() {
        return lockerVisitService.getAllLockerVisits();
    }

    @GetMapping("/get/{lockerId}")
    public LockerDailyVisit getLockerVisitById(Long lockerId) {
        return lockerVisitService.getLockerVisitById(lockerId);
    }

    @DeleteMapping("/delete/{lockerId}")
    public void deleteLockerVisitById(Long lockerId) {
        lockerVisitService.deleteLockerVisitById(lockerId);
    }
}

