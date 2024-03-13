package blanco.adapter.database.dao.service;

import org.springframework.stereotype.Service;

import blanco.adapter.database.model.Customer;

@Service
public interface CustomerService {
	Customer getCustomerByName(String name);

	void registerCustomer(Customer customer);
}
