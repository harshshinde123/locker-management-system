package com.example.locker_management_system.Services;

import com.example.locker_management_system.Entity.LockerIssue;
import com.example.locker_management_system.Repository.LockerIssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LockerIssuImpl implements LockerIssuService {
    @Autowired
    private LockerIssueRepository lockerIssueRepository;
    @Override
    public LockerIssue saveLockerIssue(LockerIssue lockerIssue) {
        return lockerIssueRepository.save(lockerIssue);
    }

    @Override
    public LockerIssue getLockerIssueById(Long Id) {
       return lockerIssueRepository.findById(Id).orElseThrow(()->
               new RuntimeException("Locker with lockerId " + Id + " not found"));
    }

    @Override
    public LockerIssue updateLockerIssue(Long Id, LockerIssue lockerIssue) {
        Optional<LockerIssue> lockerIssueOptional = lockerIssueRepository.findById(Id);
        if(lockerIssueOptional.isPresent()){
            LockerIssue lockerIssueToUpdate = lockerIssueOptional.get();

            lockerIssueToUpdate.setAccountNumber(lockerIssueOptional.get().getAccountNumber());
            lockerIssueToUpdate.setValidDateFrom(lockerIssue.getValidDateFrom());
            lockerIssueToUpdate.setValidDateTo(lockerIssue.getValidDateTo());


            return lockerIssueRepository.save(lockerIssueToUpdate);
        }
        return null;
    }

    @Override
    public void deleteLockerIssueById(Long Id) {
        lockerIssueRepository.deleteById(Id);
    }

    @Override
    public List<LockerIssue> getAllLockerIssues() {
        return lockerIssueRepository.findAll();
    }
}
