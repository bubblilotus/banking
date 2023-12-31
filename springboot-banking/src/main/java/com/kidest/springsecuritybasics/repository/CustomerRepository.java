package com.kidest.springsecuritybasics.repository;

import java.util.List;

import com.kidest.springsecuritybasics.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	List<Customer> findByEmail(String email);

}
