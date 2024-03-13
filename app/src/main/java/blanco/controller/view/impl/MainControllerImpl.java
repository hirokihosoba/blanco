package blanco.controller.view.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import blanco.controller.view.MainController;
import blanco.domain.DomainService;

@Controller
public class MainControllerImpl implements MainController {

	private final Logger logger = LoggerFactory.getLogger("appLogger");
	
	private DomainService domainService;
	
	public MainControllerImpl(DomainService ｄomainService) {
		this.domainService = ｄomainService;
	}
	
    
    @Override
	public String main(Model model) {
		model.addAttribute("message", domainService.salude());
		logger.info("ログテスト");
		return "main/index";
	}
}
