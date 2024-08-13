package com.ofss.main.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.main.ServiceRepository.CustomerService;
import com.ofss.main.domain.Customer;

@RestController
@RequestMapping("BankingApp")
@CrossOrigin(origins = "*")
public class LoginRegistrationController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("register")
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
		System.out.println(customer);
		return ResponseEntity.ok(customerService.register(customer));
	}
	
	@PostMapping("login")
	public ResponseEntity<String> loginCustomer(@RequestBody Customer customer) {
		System.out.println("hello my bro");
		System.out.println(customer);
		return ResponseEntity.ok(customerService.login(customer.getCustomerLoginId(), customer.getCustomerPassword()));
	}

}
