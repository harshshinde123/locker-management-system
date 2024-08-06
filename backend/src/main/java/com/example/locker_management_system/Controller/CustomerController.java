package com.example.locker_management_system.Controller;

import com.example.locker_management_system.Entity.CustomerRegistration;
import com.example.locker_management_system.Services.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {


    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }
    //add customer to database
    @PostMapping("/add")

    public CustomerRegistration  saveCustomer(@Valid @RequestBody CustomerRegistration CustomerRegistration) {
       return customerService.saveCustomer(CustomerRegistration);
    }
    @GetMapping("/getAll")
    public List<CustomerRegistration> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/get/{AccNo}")
    public CustomerRegistration getCustomerByAccNo( @PathVariable Long AccNo) {
        return customerService.getCustomerByAccNo(AccNo);
   }

    @DeleteMapping("/delete/{AccNo}")
    public void deleteCustomerByAccNo( @PathVariable Long AccNo) {
        customerService.deleteCustomerByAccNo(AccNo);
    }

    @PutMapping("/update{AccNo}")
    public CustomerRegistration updateCustomer(@PathVariable Long AccNo, @RequestBody CustomerRegistration customer) {
        return customerService.updateCustomer(AccNo, customer);
    }
}
