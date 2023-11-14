package blanco.domain;

import org.springframework.stereotype.Service;

import blanco.domain.model.Customer;

@Service
public interface CustomerDomainService {
	
	Customer getUser(String name);
}
