package com.exemple.cabin.customer;

import com.exemple.cabin.owner.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        List<Customer> customerList= customerRepository.findAll();
        if(customerList.size()>0){
            return customerList;
        } else{
            return new ArrayList<>();
        }
    }

    public Customer getCustomerById(int id)throws NoSuchElementException {
        Optional<Customer> customer= customerRepository.findById(id);
        if(customer.isPresent()){
            return customer.get();
        } else{
            throw new NoSuchElementException("No customer record exist or given id");
        }
    }

    public Customer updateCustomer(Customer entity) throws NoSuchElementException{
        Optional<Customer> customer = customerRepository.findById(entity.getId());
        if(customer.isPresent()){
            Customer newCustomer= customer.get();
            newCustomer.setName(entity.getName());
            newCustomer.setEmail(entity.getEmail());
            newCustomer.setPhone(entity.getPhone());
            newCustomer = customerRepository.save(newCustomer);
            return newCustomer;
        } else{
            throw new NoSuchElementException("No customer record exist or given id");
        }
    }

    public Customer saveCustomerr(Customer entity){
        return customerRepository.save(entity);

    }

    public void deleteCustomerById(int id) throws  NoSuchElementException{
        Optional <Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()){
            customerRepository.deleteById(id);
        } else{
            throw new NoSuchElementException("No customer record exist or given id");
        }
    }
}
