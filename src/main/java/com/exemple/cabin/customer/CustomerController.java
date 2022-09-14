package com.exemple.cabin.customer;

import com.exemple.cabin.owner.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/customer")
    public Customer getCustomer(int id){
        return customerService.getCustomerById(id);
    }

    @PostMapping("/customer")
    public Customer saveCustomer(Customer entity){
        return customerService.saveCustomerr(entity);
    }

    @DeleteMapping("/customer")
    public void deleteCustomer(int id){
        customerService.deleteCustomerById(id);
    }

    @PutMapping("/owner")
    public Customer updateCustomer(Customer entity){
        return customerService.updateCustomer(entity);
    }
}
