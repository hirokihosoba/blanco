package blanco.domain;

import blanco.domain.model.Customer;

public interface CustomerDomainService {
	
	Customer getUser(String name);

	void register(Customer customer);

}
