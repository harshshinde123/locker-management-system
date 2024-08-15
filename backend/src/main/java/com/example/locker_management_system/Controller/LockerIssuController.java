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
    public LockerIssue saveLockerIssu(LockerIssue lockerIssu, Long accountNumber, Long lockerId) {
        return lockerIssuService.saveLockerIssue(lockerIssu, accountNumber, lockerId);

    }

    @GetMapping("/get/{lockerId}")
    public LockerIssue getLockerIssuById(Long Id, Long accountNumber, Long lockerId) {
        return lockerIssuService.getLockerIssueById(Id,accountNumber, lockerId);
    }

    @DeleteMapping("/delete/{lockerId}")
    public void deleteLockerIssuById(Long issuId, Long accountNumber, Long lockerId) {
        lockerIssuService.deleteLockerIssueById(issuId, accountNumber, lockerId);
    }

    @PutMapping("/update/{lockerId}")
    public LockerIssue updateLockerIssu(Long issuId, LockerIssue lockerIssu, Long accountNumber, Long lockerId) {
        return lockerIssuService.updateLockerIssue(issuId, lockerIssu, accountNumber, lockerId);
    }

    @GetMapping("/getAll")
    public List<LockerIssue> getAllLockerIssues(Long accountNumber, Long lockerId) {
        return lockerIssuService.getAllLockerIssues( accountNumber, lockerId);
    }



}
