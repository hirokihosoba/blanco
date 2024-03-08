package blanco.adapter.database.dao.service.impl;

import org.springframework.stereotype.Service;

import blanco.adapter.database.dao.service.CustomerService;
import blanco.adapter.database.mapper.CustomerMapper;
import blanco.adapter.database.model.Customer;
import blanco.adapter.database.model.CustomerExample;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerMapper mapper;
	
	CustomerServiceImpl(CustomerMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public Customer getCustomerByName(String name) {
		CustomerExample example = new CustomerExample();
		example.createCriteria().andNameEqualTo(name);

		return mapper.selectByExample(example).get(0);
	}

}
