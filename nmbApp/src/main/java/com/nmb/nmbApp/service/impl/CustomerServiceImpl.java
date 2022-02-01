package com.nmb.nmbApp.service.impl;

import com.nmb.nmbApp.model.Branch;
import com.nmb.nmbApp.model.Customer;
import com.nmb.nmbApp.repository.CustomerRepository;
import com.nmb.nmbApp.service.iface.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repository;

    @Override
    public Customer add(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        Optional<Customer> customerFromDB = Optional.ofNullable(getOne(customer.getId()));
        if (customerFromDB.isEmpty()) throw new EntityNotFoundException("Customer Not Found");
        return repository.save(customer);
    }

    @Override
    public Customer getOne(Long customerId) {
        Optional<Customer> customer = repository.findById(customerId);
        if (customer.isEmpty()) throw new EntityNotFoundException("customer Not Found");

        return customer.get();
    }

    @Override
    public void deleteOne(Long branchId) {
        repository.deleteById(branchId);

    }

    @Override
    public void deleteAll() {
        repository.deleteAll();

    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = repository.findAll();
        if (customers.isEmpty()) throw new EntityNotFoundException("customers Not Available");
        return customers;
    }
}
