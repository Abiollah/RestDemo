package com.gmail.merikbest2015.service;

import com.gmail.merikbest2015.model.Customer;
import com.gmail.merikbest2015.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final RabbitTemplate rabbitTemplate;

    @Value("{spring.rabbitmq.template.exchange}")
    private String exchange;

    @Value("{spring.rabbitmq.template.routing-key}")
    private String routingKey;

    @Override
    public Customer getById(Long id) {
        Customer customer = customerRepository.findById(id).get();
        log.info(customer.toString());
        rabbitTemplate.convertAndSend(exchange, routingKey, customer.toString());
        return customer;
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
        log.info(customer.toString());
        rabbitTemplate.convertAndSend(exchange, routingKey, customer.toString());
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = customerRepository.findAll();
        rabbitTemplate.convertAndSend(exchange, routingKey, customers.toString());
        return customers;
    }
}
