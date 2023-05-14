package com.sonu.customer.repository;


import com.sonu.customer.beans.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

}
