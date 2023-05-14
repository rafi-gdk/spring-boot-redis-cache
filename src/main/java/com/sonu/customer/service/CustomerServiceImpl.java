package com.sonu.customer.service;

import com.sonu.customer.beans.entity.Customer;
import com.sonu.customer.beans.request.CustomerRequest;
import com.sonu.customer.beans.response.CustomerResponse;
import com.sonu.customer.exception.CustomerDataException;
import com.sonu.customer.repository.CustomerRepository;
import com.sonu.customer.util.CustomerUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerUtil customerUtil;

    @Autowired
    CustomerCacheService customerCacheService;

    @Autowired
    CustomerRepository repository;

    @Override
    public CustomerResponse getCustomer(String customerId) {
        CustomerResponse response;
        try {
            Customer customer = customerCacheService.findById(customerId);
            response = customerUtil.buildCustomerResponse(customer);
            log.info("getCustomer Response for " + customerId + " " + response);
        } catch (Exception e) {
            log.error("Exception Occurred in getCustomer: " + e);
            throw new CustomerDataException(e);
        }
        return response;
    }

    @Override
    public List<CustomerResponse> getAllCustomers() {
        List<CustomerResponse> customerList;
        try {
            List<Customer> customers = customerCacheService.findAllCustomers();
            customerList = customers.stream().map(i -> customerUtil.buildCustomerResponse(i)).collect(Collectors.toList());
            log.info("getAllCustomers Response " + customerList);
        } catch (Exception e) {
            log.error("Exception Occurred in getAllCustomers: " + e);
            throw new CustomerDataException(e);
        }
        return customerList;
    }

    @Override
    public CustomerResponse addCustomer(@Validated CustomerRequest customerRequest) {
        CustomerResponse customerResponse;
        try {
            repository.findById(customerRequest.getCustomerId())
                    .ifPresent(customer -> {
                        throw new CustomerDataException("Customer Already Exist");
                    });
            Customer customer = customerCacheService.saveCustomer(customerUtil.buildCustomerRequest(customerRequest));
            if (customer != null) {
                customerResponse = customerUtil.buildCustomerResponse(customer);
                log.info("addCustomer Response " + customerResponse);
            } else {
                throw new CustomerDataException("Customer Insert Failed");
            }
        } catch (Exception e) {
            log.error("Exception Occurred in addCustomer: " + e);
            throw new CustomerDataException(e);
        }
        return customerResponse;
    }

    @Override
    public CustomerResponse updateCustomer(CustomerRequest customerRequest) {
        CustomerResponse customerResponse;
        try {
            repository.findById(customerRequest.getCustomerId()).orElseThrow(() -> new CustomerDataException("Customer Not Found"));
            Customer customer = customerCacheService.updateCustomer(customerUtil.buildCustomerRequest(customerRequest), customerRequest.getCustomerId());
            if (customer != null) {
                customerResponse = customerUtil.buildCustomerResponse(customer);
                log.info("updateCustomer Response " + customerResponse);
            } else {
                throw new CustomerDataException("Customer Insert Failed");
            }
        } catch (Exception e) {
            log.error("Exception Occurred in updateCustomer: " + e);
            throw new CustomerDataException(e);
        }
        return customerResponse;
    }

    @Override
    public String deleteCustomer(String customerId) {
        try {
            customerCacheService.deleteCustomer(customerId);
            log.info("deleteCustomer Response success for " + customerId);
        } catch (Exception e) {
            log.error("Exception Occurred in deleteCustomer: " + e);
            throw new CustomerDataException(e);
        }
        return "success";
    }
}
