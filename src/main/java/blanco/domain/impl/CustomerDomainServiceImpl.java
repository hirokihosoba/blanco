package blanco.domain.impl;

import org.springframework.stereotype.Service;

import blanco.adapter.database.dao.service.impl.CustomerServiceImpl;
import blanco.domain.CustomerDomainService;
import blanco.domain.model.Customer;

@Service
public class CustomerDomainServiceImpl implements CustomerDomainService {
	
	private CustomerServiceImpl service;
	
	CustomerDomainServiceImpl(CustomerServiceImpl service){
		this.service = service;
	}

	@Override
	public Customer getUser(String name) {
		blanco.adapter.database.model.Customer customer = service.getCustomerByName(name);
		Customer out = new Customer();
		out.setName(customer.getName());
		out.setPassword(customer.getPassword());
		return out;
	}

}
