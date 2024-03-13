package blanco.controller.api.impl;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import blanco.controller.api.RegisterController;
import blanco.controller.api.dto.RegisterIn;
import blanco.service.CustomerWebService;

@RestController
public class RegisterControllerImpl implements RegisterController{

    CustomerWebService customerService;

    RegisterControllerImpl(CustomerWebService customerService) {
        this.customerService = customerService;
    }

    @Override
    @PostMapping("/register")
    public void register(@RequestBody @Validated RegisterIn in) {
        customerService.register(in.getName(), in.getPassword());
    }
    
}
