package blanco.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import blanco.adapter.database.dao.service.impl.CustomerServiceImpl;
import blanco.adapter.database.model.Customer;

@Service
public class CustomerDetailsService implements UserDetailsService {
	
	@Autowired
	CustomerServiceImpl daoService;

	@Override
	public CustomerDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer customer = daoService.getCustomerByName(username);
		if (customer == null) {
			throw new UsernameNotFoundException("not found user : " + username);
		}
		return new CustomerDetails(customer);
	}
	
}