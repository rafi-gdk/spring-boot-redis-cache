package com.sonu.customer.service;

import com.sonu.customer.beans.entity.Customer;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CustomerCacheService {

    @Cacheable(value = "Customer", key = "#customerId")
    Customer findById(String customerId);

    @Cacheable(value = "Customer")
    List<Customer> findAllCustomers();

    @Cacheable(value = "Customer")
    Customer saveCustomer(Customer customer);

    @Cacheable(value = "Customer", key = "#customerId")
    Customer updateCustomer(Customer customer, String customerId);

    @Caching(
            evict = {@CacheEvict("Customer"), @CacheEvict(value = "Customer", key = "#customerId")
            })
    void deleteCustomer(String customerId);
}
