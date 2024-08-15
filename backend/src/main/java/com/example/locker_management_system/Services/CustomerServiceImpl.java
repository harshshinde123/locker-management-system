package com.example.locker_management_system.Services;

import com.example.locker_management_system.CustomException.UserException;
import com.example.locker_management_system.Entity.CustomerRegistration;
import com.example.locker_management_system.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    @Override
    public CustomerRegistration saveCustomer(CustomerRegistration customer) {
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



}
