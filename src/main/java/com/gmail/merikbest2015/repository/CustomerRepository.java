package com.gmail.merikbest2015.repository;

import com.gmail.merikbest2015.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
