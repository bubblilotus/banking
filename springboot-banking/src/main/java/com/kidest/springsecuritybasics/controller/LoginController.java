package com.kidest.springsecuritybasics.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.kidest.springsecuritybasics.model.Customer;
import com.kidest.springsecuritybasics.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {
@Autowired
private PasswordEncoder passwordEncoder;
	@Autowired
	private CustomerRepository customerRepository;
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody Customer customer){
		Customer savedCustomer = null;
		ResponseEntity response = null;
		try{
			String hashedPwd = passwordEncoder.encode(customer.getPwd());
			customer.setPwd(hashedPwd);
			LocalDateTime ldt = LocalDateTime.now();
			String formattedDateStr = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH)
					.format(ldt);
			customer.setCreateDt(formattedDateStr);
			savedCustomer = customerRepository.save(customer);
			if(savedCustomer.getId() > 0){
				response = ResponseEntity.status(HttpStatus.CREATED)
						.body("User registered");
			}
		}catch(Exception ex){
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An exception occured due to " + ex.getMessage());
		}
		return response;
	}
	@RequestMapping("/user")
	public Customer getUserDetailsAfterLogin(Principal user) {
		List<Customer> customers = customerRepository.findByEmail(user.getName());
		if (customers.size() > 0) {
			return customers.get(0);
		}else {
			return null;
		}

	}

}
