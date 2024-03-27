package blanco.domain.impl;

import java.util.Objects;

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
	public Customer getUser(String id) {
		blanco.adapter.database.model.Customer customer = service.getCustomerById(id);
		if(Objects.isNull(customer)){
			return null;
		}
		Customer out = new Customer();
		out.setCustomerId(customer.getCustomerId());
		out.setPassword(customer.getPassword());
		return out;
	}

	@Override
	public void register(Customer customer) {
		blanco.adapter.database.model.Customer daoCustomer = new blanco.adapter.database.model.Customer();
		daoCustomer.setCustomerId(customer.getCustomerId());
		daoCustomer.setPassword(customer.getPassword());
		service.registerCustomer(daoCustomer);
	}

}
