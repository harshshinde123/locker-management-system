package com.example.locker_management_system.Services;

import com.example.locker_management_system.Entity.CustomerRegistration;
import com.example.locker_management_system.Entity.LockerIssue;
import com.example.locker_management_system.Entity.LockerMaster;
import com.example.locker_management_system.Repository.CustomerRepository;
import com.example.locker_management_system.Repository.LockerIssueRepository;
import com.example.locker_management_system.Repository.LockerMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class LockerIssuImpl implements LockerIssuService {
    @Autowired
    private LockerIssueRepository lockerIssueRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LockerMasterRepository lockerMasterRepository;
    public LockerIssue saveLockerIssue(LockerIssue lockerIssue, Long accountNumber, Long lockerId) {
        // Fetch the CustomerRegistration entity by its accountNumber
        CustomerRegistration customerRegistration = customerRepository.findById(accountNumber).orElseThrow(() ->
                new RuntimeException("Customer with Account Number " + accountNumber + " not found"));

        // Fetch the LockerMaster entity by its lockerId
        LockerMaster lockerMaster = lockerMasterRepository.findById(lockerId).orElseThrow(() ->
                new RuntimeException("Locker with Id " + lockerId + " not found"));

        // Set the relationships before saving the LockerIssue entity
        lockerIssue.setCustomerRegistration(customerRegistration);
        lockerIssue.setLockerMaster(lockerMaster);

        // Now save the LockerIssue entity with the relationships set
        return lockerIssueRepository.save(lockerIssue);
    }




    @Override
    public LockerIssue getLockerIssueById(Long id, Long accountNumber, Long lockerId) {

        // Fetch the CustomerRegistration entity by its accountNumber
        CustomerRegistration customerRegistration = customerRepository.findById(accountNumber).orElseThrow(() ->
                new RuntimeException("Customer with Account Number " + accountNumber + " not found"));

        // Fetch the LockerMaster entity by its lockerId
        LockerMaster lockerMaster = lockerMasterRepository.findById(lockerId).orElseThrow(() ->
                new RuntimeException("Locker with Id " + lockerId + " not found"));


        // Fetch the LockerIssue entity by its id
        LockerIssue lockerIssue = lockerIssueRepository.findById(id).orElseThrow(() ->
                new RuntimeException("LockerIssue with Id " + id + " not found"));



        // Check if lockerId matches
        lockerIssue.setLockerMaster(lockerMaster);
        // Check if accountNumber matches
        lockerIssue.setCustomerRegistration(customerRegistration);


        return lockerIssue;
    }



    @Override
    public LockerIssue updateLockerIssue(Long Id, LockerIssue lockerIssue, Long accountNumber, Long lockerId) {
        // Fetch the CustomerRegistration entity by its accountNumber
        CustomerRegistration customerRegistration = customerRepository.findById(accountNumber).orElseThrow(() ->
                new RuntimeException("Customer with Account Number " + accountNumber + " not found"));

        // Fetch the LockerMaster entity by its lockerId
        LockerMaster lockerMaster = lockerMasterRepository.findById(lockerId).orElseThrow(() ->
                new RuntimeException("Locker with Id " + lockerId + " not found"));

        Optional<LockerIssue> lockerIssueOptional = lockerIssueRepository.findById(Id);
        if(lockerIssueOptional.isPresent()){
            LockerIssue lockerIssueToUpdate = lockerIssueOptional.get();

            lockerIssueToUpdate.setAccNo(lockerIssueOptional.get().getAccNo());
            lockerIssueToUpdate.setValidDateFrom(lockerIssue.getValidDateFrom());
            lockerIssueToUpdate.setValidDateTo(lockerIssue.getValidDateTo());


            LockerIssue lockerIssue1= lockerIssueRepository.save(lockerIssueToUpdate);
            lockerIssue1.setCustomerRegistration(customerRegistration);
            lockerIssue1.setLockerMaster(lockerMaster);
            return lockerIssue1;
        }
        return null;
    }

    @Override
    public void deleteLockerIssueById(Long Id, Long accountNumber, Long lockerId) {

        // Fetch the CustomerRegistration entity by its accountNumber
        CustomerRegistration customerRegistration = customerRepository.findById(accountNumber).orElseThrow(() ->
                new RuntimeException("Customer with Account Number " + accountNumber + " not found"));

        // Fetch the LockerMaster entity by its lockerId
        LockerMaster lockerMaster = lockerMasterRepository.findById(lockerId).orElseThrow(() ->
                new RuntimeException("Locker with Id " + lockerId + " not found"));

        lockerIssueRepository.deleteById(Id);
    }

    @Override
    public List<LockerIssue> getAllLockerIssues(Long accountNumber, Long lockerId) {
        // Fetch the CustomerRegistration entity by its accountNumber
        CustomerRegistration customerRegistration = customerRepository.findById(accountNumber).orElseThrow(() ->
                new RuntimeException("Customer with Account Number " + accountNumber + " not found"));

        // Fetch the LockerMaster entity by its lockerId
        LockerMaster lockerMaster = lockerMasterRepository.findById(lockerId).orElseThrow(() ->
                new RuntimeException("Locker with Id " + lockerId + " not found"));

        List<LockerIssue> lockerIssues = lockerIssueRepository.findAll().stream()
                .map(lockerIssue -> {
                    lockerIssue.setCustomerRegistration(customerRegistration);
                    lockerIssue.setLockerMaster(lockerMaster);
                    return lockerIssue;
                })
                .collect(Collectors.toList());

        return lockerIssues;
    }
}
