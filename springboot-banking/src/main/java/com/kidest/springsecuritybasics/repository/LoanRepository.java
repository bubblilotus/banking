package com.kidest.springsecuritybasics.repository;

import java.util.List;

import com.kidest.springsecuritybasics.model.Loans;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface LoanRepository extends CrudRepository<Loans, Long> {
	
	List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId);

}
