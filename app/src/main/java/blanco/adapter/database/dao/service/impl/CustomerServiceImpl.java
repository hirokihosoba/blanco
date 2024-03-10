package blanco.adapter.database.dao.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
		List<Customer> customer = mapper.selectByExample(example);
		if (CollectionUtils.isEmpty(customer)) {
			return null;
		}
		return customer.get(0);
	}

}
