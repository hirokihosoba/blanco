package blanco.service.impl;

import org.springframework.stereotype.Service;

import blanco.domain.impl.CustomerDomainServiceImpl;
import blanco.domain.model.Customer;
import blanco.service.CustomerWebService;

@Service
public class CustomerWebServiceImpl implements CustomerWebService {

    public CustomerDomainServiceImpl customerService;

    CustomerWebServiceImpl(CustomerDomainServiceImpl customerService) {
        this.customerService = customerService;
    }

    @Override
    public void register(String id, String password) {
        Customer customer = new Customer();
        customer.setCustomerId(id);
        customer.setPassword(password);
        customerService.register(customer);
    }
    
}
