package com.kidest.springsecuritybasics.controller;

import java.util.List;

import com.kidest.springsecuritybasics.model.AccountTransactions;
import com.kidest.springsecuritybasics.model.Customer;
import com.kidest.springsecuritybasics.repository.AccountTransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BalanceController {

	@Autowired
	private AccountTransactionsRepository accountTransactionsRepository;
	
	@PostMapping("/myBalance")
	public List<AccountTransactions> getBalanceDetails(@RequestBody Customer customer) {
		List<AccountTransactions> accountTransactions = accountTransactionsRepository.
				findByCustomerIdOrderByTransactionDtDesc(customer.getId());
		if (accountTransactions != null ) {
			return accountTransactions;
		}else {
			return null;
		}
	}
}
