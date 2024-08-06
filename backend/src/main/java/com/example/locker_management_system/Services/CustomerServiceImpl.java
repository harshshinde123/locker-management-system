package com.example.locker_management_system.Services;

import com.example.locker_management_system.CustomException.UserException;
import com.example.locker_management_system.Entity.CustomerRegistration;
import com.example.locker_management_system.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    @Override
    public CustomerRegistration saveCustomer(CustomerRegistration customer) {
        validateAadhaarNumber(customer);
        validatePhone(customer);
        return customerRepository.save(customer);
    }

    @Override
    public List<CustomerRegistration> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerRegistration getCustomerByAccNo(Long AccNo) {
        return customerRepository.findById(AccNo).orElseThrow(()->
                new RuntimeException("Customer with AccNo " + AccNo + " not found"));
    }

    @Override
    public void deleteCustomerByAccNo(Long AccNo) {
        customerRepository.deleteById(AccNo);
    }

    @Override
    public CustomerRegistration updateCustomer(Long id, CustomerRegistration customer) {
        Optional<CustomerRegistration> customerOptional = customerRepository.findById(id);
        if(customerOptional.isPresent()){
            CustomerRegistration customerToUpdate = customerOptional.get();
            customerToUpdate.setName(customer.getName());
            customerToUpdate.setEmail(customer.getEmail());
            customerToUpdate.setAddress(customer.getAddress());
            customerToUpdate.setAadharNumber(customerOptional.get().getAadharNumber());
            customerToUpdate.setPhoneNumber(customer.getPhoneNumber());
            customerToUpdate.setOpeningdate(customerOptional.get().getOpeningdate());
            customerToUpdate.setAccountNumber(customerOptional.get().getAccountNumber());
            return customerRepository.save(customerToUpdate);
        }
        return null;
    }
    public void validateAadhaarNumber(CustomerRegistration customer) {
        // Check if the Aadhaar number matches the required pattern
        String aadhaarNumber = customer.getPhoneNumber();
        if (aadhaarNumber == null || !aadhaarNumber.matches("\\d{12}")) {
            throw new UserException("Aadhaar number should be exactly 12 digits and numeric");
        }
    }
    public void validatePhone(CustomerRegistration customer) {
        // Check if the phone number matches Indian phone number norms
        String phoneNumber = customer.getPhoneNumber();
        if (phoneNumber == null || !phoneNumber.matches("[6-9]\\d{9}")) {
            throw new UserException("Phone number should be exactly 10 digits, start with 6-9 and be numeric");
        }
    }


}
