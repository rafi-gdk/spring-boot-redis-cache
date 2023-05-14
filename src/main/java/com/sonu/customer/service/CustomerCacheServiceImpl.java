package com.sonu.customer.service;

import com.sonu.customer.beans.entity.Customer;
import com.sonu.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerCacheServiceImpl implements CustomerCacheService {

    @Autowired
    CustomerRepository repository;

    @Override
    public Customer findById(String customerId) {
        Optional<Customer> customer = repository.findById(customerId);
        return customer.isPresent() ? customer.get() : null;
    }

    @Override
    public List<Customer> findAllCustomers() {
        return repository.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer, String customerId) {
        return repository.save(customer);
    }

    @Override
    public void deleteCustomer(String customerId) {
        repository.deleteById(customerId);
    }
}
