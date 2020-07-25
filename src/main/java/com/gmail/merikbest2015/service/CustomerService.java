package com.gmail.merikbest2015.service;

import com.gmail.merikbest2015.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer getById(Long id);

    void save(Customer customer);

    void delete(Long id);

    List<Customer> getAll();
}
