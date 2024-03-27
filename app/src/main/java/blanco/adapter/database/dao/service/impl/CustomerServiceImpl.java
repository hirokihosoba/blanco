package blanco.adapter.database.dao.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import blanco.adapter.database.dao.service.CustomerService;
import blanco.adapter.database.mapper.CustomerMapper;
import blanco.adapter.database.model.Customer;
import blanco.adapter.database.model.CustomerExample;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private final Logger logger = LoggerFactory.getLogger("appLogger");

	private CustomerMapper mapper;
	
	CustomerServiceImpl(CustomerMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public Customer getCustomerById(String id) {
		CustomerExample example = new CustomerExample();
		example.createCriteria().andCustomerIdEqualTo(id);
		List<Customer> customer = mapper.selectByExample(example);
		if (CollectionUtils.isEmpty(customer)) {
			return null;
		}
		return customer.get(0);
	}

	@Override
	public void registerCustomer(Customer customer) {
		try {
			mapper.insert(customer);
		} catch (Exception e) {
			logger.error("ERROR", e);
		}
	}

}
