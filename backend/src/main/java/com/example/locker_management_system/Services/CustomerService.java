package com.example.locker_management_system.Services;

import com.example.locker_management_system.Entity.CustomerRegistration;

import java.util.List;

public interface CustomerService{
     CustomerRegistration saveCustomer(CustomerRegistration customer);
     List<CustomerRegistration> getAllCustomers();
     CustomerRegistration getCustomerByAccNo(Long AccNo);
     void deleteCustomerByAccNo(Long AccNo);
     CustomerRegistration updateCustomer(Long id, CustomerRegistration customer);


}
