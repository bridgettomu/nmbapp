package com.nmb.nmbApp.service.iface;

import com.nmb.nmbApp.model.Account;
import com.nmb.nmbApp.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer add(Customer customer);
    Customer update(Customer customer);
    Customer getOne(Long customerId);
    void deleteOne(Long customerId);
    void deleteAll();
    List<Customer> getAll();
}
