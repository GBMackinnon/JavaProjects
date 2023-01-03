package com.duncan.jpa;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.duncan.jpa.entitys.Customer;
import com.duncan.jpa.repository.CustomerRepository;

@SpringBootTest
class SpringJpaDataBaseApplicationTests {

	@Autowired
	private CustomerRepository customerRepo;

	@BeforeEach
	void setUp() throws Exception {
		customerRepo.save(new Customer("Jack", "Bauer"));
		customerRepo.save(new Customer("Jack", "jo"));
		customerRepo.save(new Customer("Chloe", "O'Brian"));
		customerRepo.save(new Customer("Kim", "Bauer"));
		customerRepo.save(new Customer("David", "Palmer"));
		customerRepo.save(new Customer("Michelle", "Dessler"));
	}

	@Test
	void findById() {

		long count = customerRepo.count();
		System.out.println(count);

		Customer cust = customerRepo.findById(3);
		System.out.println(cust.toString());

		Assertions.assertTrue(cust.getFirstName().equals("Chloe"));
	}

	@Test
	void findByLast() {
		List<Customer> customers = customerRepo.findByFirstName("Jack");
		System.out.println(customers.size());
		for (Customer customer : customers) {
			System.out.println(customer.toString());
			Assertions.assertTrue(customer.getFirstName().equals("Jack"));
		}
	}

	@Test
	void findByFirst() {
		List<Customer> customers = customerRepo.findByLastName("Palmer");
		for (Customer customer : customers) {
			System.out.println(customer.toString());
			Assertions.assertTrue(customer.getFirstName().equals("David"));
		}
	}

}
