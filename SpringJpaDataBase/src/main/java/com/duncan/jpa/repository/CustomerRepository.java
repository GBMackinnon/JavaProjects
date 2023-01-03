package com.duncan.jpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.duncan.jpa.entitys.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

  List<Customer> findByLastName(String lastName);
  List<Customer> findByFirstName(String firstName);
  //List<Customer> findByFirstAndLastName(String firstName);

  Customer findById(long id);
}