package com.example.locker_management_system.Controller;

import com.example.locker_management_system.Entity.LockerIssue;
import com.example.locker_management_system.Services.LockerIssuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lockerIssu")
public class LockerIssuController {
    @Autowired
    private LockerIssuService lockerIssuService;

    //add locker to database
    @PostMapping("/add")
    public LockerIssue saveLockerIssu(LockerIssue lockerIssu) {
        return lockerIssuService.saveLockerIssue(lockerIssu);

    }

    @GetMapping("/get/{lockerId}")
    public LockerIssue getLockerIssuById(Long lockerId) {
        return lockerIssuService.getLockerIssueById(lockerId);
    }

    @DeleteMapping("/delete/{lockerId}")
    public void deleteLockerIssuById(Long lockerId) {
        lockerIssuService.deleteLockerIssueById(lockerId);
    }

    @PutMapping("/update/{lockerId}")
    public LockerIssue updateLockerIssu(Long lockerId, LockerIssue lockerIssu) {
        return lockerIssuService.updateLockerIssue(lockerId, lockerIssu);
    }

    @GetMapping("/getAll")
    public List<LockerIssue> getAllLockerIssues() {
        return lockerIssuService.getAllLockerIssues();
    }



}
