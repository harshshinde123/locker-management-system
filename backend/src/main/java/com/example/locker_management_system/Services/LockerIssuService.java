package com.example.locker_management_system.Services;

import com.example.locker_management_system.Entity.LockerIssue;

import java.util.List;

public interface LockerIssuService {
    LockerIssue saveLockerIssue(LockerIssue lockerIssue);
    LockerIssue getLockerIssueById(Long Id);
    LockerIssue updateLockerIssue(Long Id, LockerIssue lockerIssue);
    void deleteLockerIssueById(Long Id);
    List<LockerIssue>getAllLockerIssues();
}
