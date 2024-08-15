package com.example.locker_management_system.Services;

import com.example.locker_management_system.Entity.LockerIssue;

import java.util.List;

public interface LockerIssuService {
    LockerIssue saveLockerIssue(LockerIssue lockerIssue, Long accountNumber, Long lockerId);
    LockerIssue getLockerIssueById(Long Id, Long accountNumber, Long lockerId);
    LockerIssue updateLockerIssue(Long Id, LockerIssue lockerIssue, Long accountNumber, Long lockerId);
    void deleteLockerIssueById(Long Id, Long accountNumber, Long lockerId);
    List<LockerIssue>getAllLockerIssues(Long accountNumber, Long lockerId);
}
